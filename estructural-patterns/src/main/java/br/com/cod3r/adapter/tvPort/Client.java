package br.com.cod3r.adapter.tvPort;

import br.com.cod3r.adapter.tvPort.adapters.HDMIToOldMonitorAdapter;
import br.com.cod3r.adapter.tvPort.adapters.HDMIToVGAAdapter;
import br.com.cod3r.adapter.tvPort.devices.Computer;
import br.com.cod3r.adapter.tvPort.devices.OldMonitor;
import br.com.cod3r.adapter.tvPort.devices.TV;

public class Client {

	public static void main(String[] args) {
		Computer pc = new Computer();
		TV tv = new TV();
		pc.connectPort(tv);
		pc.sendImageAndSound("Cat and rainbow", "Nyan cat song");
		
		Computer pc2 = new Computer();
		OldMonitor monitor = new OldMonitor();
		// pc2.connectPort(monitor); // ERROR
		System.out.println("------ Monitor Class Adapter ----------");
		pc2.connectPort(new HDMIToVGAAdapter(monitor));
		pc2.sendImageAndSound("PD2 image", "PC2 sound");

		Computer pc3 = new Computer();
		HDMIToOldMonitorAdapter adapter = new HDMIToOldMonitorAdapter();
		pc2.connectPort(adapter);
		pc2.sendImageAndSound("PD3 image", "PC3 sound");
	}
}
