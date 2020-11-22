package com.assignment.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 */
public abstract class Client {
	private final int serverPort;

	public Client(int serverPort) {
		this.serverPort = serverPort;
	}

	public void executePrime() {
		ProcessThread processThread = new ProcessThread(serverPort);
		new Thread(processThread).start();
	}

	//Client implements :To process
	public abstract void processData(DataInputStream in, DataOutputStream out) throws InterruptedException;
	
	class ProcessThread implements Runnable {
		private final Socket socket;
		private final DataInputStream in;
		private final DataOutputStream out;

		ProcessThread(int serverPort) {
			String hostName = "127.0.0.1";
			try {
				this.socket = new Socket(hostName, serverPort);
				this.in = new DataInputStream(socket.getInputStream());
				this.out = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					try {
						processData(in, out);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						return;
					}
				}
			} finally {
				close();
			}
		}

		private void close() {
			try {
				socket.close();
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
