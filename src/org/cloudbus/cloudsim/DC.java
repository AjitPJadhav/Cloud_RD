/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.network.datacenter.EdgeSwitch;
import org.cloudbus.cloudsim.network.datacenter.NetDatacenterBroker;
import org.cloudbus.cloudsim.network.datacenter.NetworkConstants;
import org.cloudbus.cloudsim.network.datacenter.NetworkDatacenter;
import org.cloudbus.cloudsim.network.datacenter.NetworkHost;
import org.cloudbus.cloudsim.network.datacenter.NetworkVm;
import org.cloudbus.cloudsim.network.datacenter.NetworkVmAllocationPolicy;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;
/**
 *
 * @author Sabarish
 */
public class DC
{
    int request=0;
    //int z1,z2,z3,z4,z5;
    int t1,t2,t3,t4,t5;
     private static List<Cloudlet> cloudletList;
     private static List<Vm> vmlist;
     public void config()
     {

                        double a=Math.random()*100;
                        int b=(int) Math.ceil(a);
                        int cloudletid=0;
                        int[] r_length={30000,40000,50000};
                        int[] r_outputSize={200,300,400};
                        int[] r_fileSize={200,300,400};
                        int pes=1;
                        int rlength=(int) b%3;
                        int routputsize=(int) b%3;
                        int rfilesize=(int) b%3;
                        int length=r_length[rlength];
                        int outputSize=r_outputSize[routputsize];
                        int fileSize=r_fileSize[rfilesize];
                        //Fourth step: Create one virtual machine
                        vmlist = new ArrayList<>();
                   //VM description
              
                        int vmid = 0;
                        int pesNumber = 1; //number of cpus
                        String[] r_vmm = {"Xen","jasmine","SC","Vcenter"}; //VMM name
                        int rvmm=(int) b%3;
                        String vmm=r_vmm[rvmm];
                 int[] r_mips ={100,200,300};

		
		int[] r_ram = {128,256,512}; // VM memory (MB)
		long[] r_size = {10000,20000,30000}; // VM storage
		int[] r_bw = {100,200,300};
                int rmips=(int) b%3;
                int rram=(int) b%3;
                int rsize=(int) b%3;
                int rbw=(int) b%3;
                int mips=r_mips[rmips];
                int ram=r_ram[rram];
                long size=r_size[rsize];
                int bw=r_bw[rbw];
                DC d=new DC();
                d.create(vmid,mips,size,ram,bw,pesNumber,vmm,cloudletid,length,outputSize,fileSize,pes);
     
                request++;
                cloudletid++;       
     }
     void create(int vmid,int mips,long size,int ram,int bw,int pesNumber,String vmm,int id,int length,int outputSize,int fileSize,int pes)
     {              double z1=0,z2=0,z3=0,z4=0,z5=0;
                   int t1=0,t2=0,t3=0,t4=0,t5=0;
                   int x1=0,x2=0,x3=0,x4=0,x5=0;
                  double a=Math.random()*100;
                   int b=(int) Math.ceil(a);
                   b=  (int) (a%5);
                Log.printLine("Trying to create Vm in Zone "+b);
                if(request==0||request==8)
                {   request=0;
                    switch(b)
                {
                    case 0:
                        request++;
                        t1+= Zone1.Zone1(mips,size,ram,bw,pesNumber,vmm);
                        Zone1.submitcloudlet(t1,id, length, outputSize, fileSize);
                        z1=t1/request;
                        break;
                    case 1:
                        request++;
                       t2+= Zone2.Zone2(mips,size,ram,bw,pesNumber,vmm);
                       Zone2.submitcloudlet(t2,id, length, outputSize, fileSize);
                       z2=t2/request;
      
                        break;
                    case 2:
                        request++;
                    t3+=Zone3.Zone3(mips,size,ram,bw,pesNumber,vmm);
                    Zone3.submitcloudlet(t3,id, length, outputSize, fileSize);
                    z3=t3/request;   
                    break;
                    case 3:
                        request++;
                       t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                       Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
                       z4=t4/request; 
                       break;
                                    }
                }
                else
                {
      double[] q={z1,z2,z3,z4};
      double[] w=q;
      for(int r=0;r<4;r++)
      {
          if(q[r]<q[r+1])
          {
              double temp=q[r];
              q[r]=q[r+1];
              q[r+1]=temp;
          }
          
      }
      for(int r=0;r<4;r++)
      {
          if(w[r]==q[0])
           {   
              x1=r;
           }   
          else if(w[r]==q[1])
          {
              x2=r;
          }
          else if(w[r]==q[2])
          {
              x3=r;
          }
          else if(w[r]==q[3])
          {
              x4=r;
          }
          else 
          {
              x5=r;
          }
          
      }
      switch(x1)
      {
          case 0:
              t1+=Zone1.Zone1(mips,size,ram,bw,pesNumber,vmm);
              Zone1.submitcloudlet(t1,id, length, outputSize, fileSize);
              break;
          case 1:
              t2+=Zone2.Zone2(mips,size,ram,bw,pesNumber,vmm);
              Zone2.submitcloudlet(t2,id, length, outputSize, fileSize);
              break;
          case 2:
              t3+=Zone3.Zone3(mips,size,ram,bw,pesNumber,vmm);
              Zone3.submitcloudlet(t3,id, length, outputSize, fileSize);
              break;
          case 3:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
              Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
          default:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
              Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
      }
      switch(x2)
      {
          case 0:
              t1+=Zone1.Zone1(mips,size,ram,bw,pesNumber,vmm);
        Zone1.submitcloudlet(t1,id, length, outputSize, fileSize);
              break;
          case 1:
              t2+=Zone2.Zone2(mips,size,ram,bw,pesNumber,vmm);
                      Zone2.submitcloudlet(t2,id, length, outputSize, fileSize);
              break;
          case 2:
              t3+=Zone3.Zone3(mips,size,ram,bw,pesNumber,vmm);
                   Zone3.submitcloudlet(t3,id, length, outputSize, fileSize);
              break;
          case 3:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                      Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
          default:
              t5+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                      Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
      }
      switch(x3)
      {
          case 0:
              t1+=Zone1.Zone1(mips,size,ram,bw,pesNumber,vmm);
                      Zone1.submitcloudlet(t1,id, length, outputSize, fileSize);
              break;
          case 1:
             t2+= Zone2.Zone2(mips,size,ram,bw,pesNumber,vmm);
                      Zone2.submitcloudlet(t2,id, length, outputSize, fileSize);
              break;
          case 2:
              t3+=Zone3.Zone3(mips,size,ram,bw,pesNumber,vmm);
                      Zone3.submitcloudlet(t3,id, length, outputSize, fileSize);
              break;
          case 3:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                      Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
          default:
              t5+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                      Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
      }
      switch(x4)
      {
          case 0:
              t1+=Zone1.Zone1(mips,size,ram,bw,pesNumber,vmm);
                      Zone1.submitcloudlet(t1,id, length, outputSize, fileSize);
              break;
          case 1:
              t2+=Zone2.Zone2(mips,size,ram,bw,pesNumber,vmm);
              Zone2.submitcloudlet(t2,id, length, outputSize, fileSize);
              break;
          case 2:
              
             t3+=Zone3.Zone3(mips,size,ram,bw,pesNumber,vmm);            
                   Zone3.submitcloudlet(t3,id, length, outputSize, fileSize);
             break;
          case 3:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
                      Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
          default:
              t4+=Zone4.Zone4(mips,size,ram,bw,pesNumber,vmm);
              Zone4.submitcloudlet(t4,id, length, outputSize, fileSize);
              break;
      }
                }

     }
     public static void DC(int a1,int b1,int c1,int d1,int e1,int f1,int g1,int h1)
    { 
        double z1 = 0,z2 = 0,z3 = 0,z4=0,z5;
    int t1 = 0,t2=0,t3=0,t4=0,t5=0;
    int x1 = 0,x2=0,x3=0,x4=0,x5=0;
        int request = 0;
        System.out.println("Datacenters");
        Log.printLine("Starting to create the datacenters");
        long starttime=System.currentTimeMillis();
        long finish_broker,finish_alg;
        long exec_broker,exec_alg = 0;
		try {
			int num_user = 1; // number of cloud users
			Calendar calendar = Calendar.getInstance();
			boolean trace_flag = false; // mean trace events

			// Initialize the CloudSim library
			CloudSim.init(num_user, calendar, trace_flag);

			// Second step: Create Datacenters
			// Datacenters are the resource providers in CloudSim. We need at
			// list one of them to run a CloudSim simulation
			NetworkDatacenter datacenter0 = createDatacenter("Datacenter_0",a1);
                        NetworkDatacenter datacenter1 = createDatacenter("Datacenter_1",b1);
                        NetworkDatacenter datacenter2 = createDatacenter("Datacenter_2",c1);
                        NetworkDatacenter datacenter3 = createDatacenter("Datacenter_3",d1);
                        NetworkDatacenter datacenter4 = createDatacenter("Datacenter_4",e1);
                        NetworkDatacenter datacenter5 = createDatacenter("Datacenter_5",f1);
			NetworkDatacenter datacenter6 = createDatacenter("Datacenter_6",g1);
                        NetworkDatacenter datacenter7 = createDatacenter("Datacenter_7",h1);
                        // Third step: Create Broker
			DatacenterBroker broker = createBroker();
                        
			/*broker.setLinkDC(datacenter0);
                        broker.setLinkDC(datacenter1);
                        broker.setLinkDC(datacenter2);
                        broker.setLinkDC(datacenter3);
                        broker.setLinkDC(datacenter4);
                        broker.setLinkDC(datacenter5);
                        broker.setLinkDC(datacenter6);
                        broker.setLinkDC(datacenter7);*/
			// broker.setLinkDC(datacenter0);
			// Fifth step: Create one Cloudlet
                        int brokerId=broker.getId();
              for(int vmid=0;vmid<5;vmid++)         
              {   DC d=new DC();
              
                  d.config();
                  
              }
              finish_alg=System.currentTimeMillis();
              exec_alg=finish_alg-starttime;
              
Log.printLine("Proposed Algorithm execution time: "+exec_alg);

        
        
              int id=0;
                        int length=40000;
                        int outputSize=300;
                        int fileSize=300;
                        int pes=1;
                        
                        //Fourth step: Create one virtual machine
                        vmlist = new ArrayList<>();
                   //VM description
              
                        int vmid = 0;
                        int pesNumber = 1; //number of cpus
                        String vmm = "Xen"; //VMM name
                        
                        
                 int[] r_mips ={100,200,300};

		
		int[] r_ram = {128,256,512}; // VM memory (MB)
		long[] r_size = {10000,20000,30000}; // VM storage
		int[] r_bw = {100,200,300};
                double a=Math.random()*100;
                int b=(int) Math.ceil(a);
                int rmips=(int) b%3;
                int rram=(int) b%3;
                int rsize=(int) b%3;
                int rbw=(int) b%3;
                int mips=r_mips[rmips];
                int ram=r_ram[rram];
                long size=r_size[rsize];
                int bw=r_bw[rbw];
              NetworkVm vm1 = (NetworkVm) new NetworkVm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerSpaceShared());
                        //the second VM will have twice the priority of VM1 and so will receive twice CPU time
              
               Log.printLine("VM "+vmid+" created");  
              vmid++;
                
                NetworkVm vm2 = (NetworkVm) new NetworkVm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerSpaceShared());

                
               Log.printLine("VM "+vmid+" created");
                vmid++;
                
                NetworkVm vm3 = (NetworkVm) new NetworkVm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerSpaceShared());
                
               Log.printLine("VM "+vmid+" created");
               vmid++;
                
                NetworkVm vm4 = (NetworkVm) new NetworkVm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerSpaceShared());

               Log.printLine("VM "+vmid+" created");
                //add the VMs to the vmList
               vmlist.add(vm1);
                        //add the VMs to the vmList
               vmlist.add(vm2);
               vmlist.add(vm3);
               vmlist.add(vm4);
               
                
  //                      vmlist.add(vm2);
             
			// submit vm list to the broker
                Log.printLine("Using the broker algorithm");
			broker.submitVmList(vmlist);
                        
                        cloudletList = new ArrayList<Cloudlet>();
                          
                        //Cloudlet properties
                        //int id = 0;
                        //long length = 40000;
                        //long fileSize = 300;
                        //long outputSize = 300;
                        UtilizationModel utilizationModel = new UtilizationModelFull();
                        Cloudlet cloudlet1 = new Cloudlet(id, length, pes, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
                        cloudlet1.setUserId(brokerId);
                        
                        id++;
                        Cloudlet cloudlet2 = new Cloudlet(id, length, pes, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
                        cloudlet2.setUserId(brokerId);

                         id++;
                        Cloudlet cloudlet3 = new Cloudlet(id, length, pes, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
                        cloudlet2.setUserId(brokerId);

                         id++;
                        Cloudlet cloudlet4 = new Cloudlet(id, length, pes, fileSize, outputSize, utilizationModel, utilizationModel, utilizationModel);
                        cloudlet2.setUserId(brokerId);

                        //add the cloudlets to the list
                        cloudletList.add(cloudlet1);
                        cloudletList.add(cloudlet2);
                        cloudletList.add(cloudlet3);
                        cloudletList.add(cloudlet4);
                        //submit cloudlet list to the broker
                        broker.submitCloudletList(cloudletList);
                       
                        //bind the cloudlets to the vms. This way, the broker
                        // will submit the bound cloudlets only to the specific VM
                       broker.bindCloudletToVm(cloudlet1.getCloudletId(),vm1.getId());
                        broker.bindCloudletToVm(cloudlet2.getCloudletId(),vm2.getId());

                        CloudSim.startSimulation();
                        NetworkTopology.buildNetworkTopology("topology.brite");

			//maps CloudSim entities to BRITE entities
			//Datacenter0 will correspond to BRITE node 0
			int briteNode=0;
			NetworkTopology.mapNode(datacenter0.getId(),briteNode);

			//Datacenter1 will correspond to BRITE node 2
			briteNode=1;
			NetworkTopology.mapNode(datacenter1.getId(),briteNode);

			//DC 2 will correspond to BRITE node 3
			briteNode=2;
			NetworkTopology.mapNode(datacenter2.getId(),briteNode);

			//DC 3 will correspond to BRITE node 4
			briteNode=3;
			NetworkTopology.mapNode(datacenter3.getId(),briteNode);

                        briteNode=4;
                        NetworkTopology.mapNode(datacenter4.getId(),briteNode);
                        
                        briteNode=5;
                        NetworkTopology.mapNode(datacenter5.getId(),briteNode);
                        
                        briteNode=6;
                        NetworkTopology.mapNode(datacenter6.getId(),briteNode);
                        
                        briteNode=7;
                        NetworkTopology.mapNode(datacenter7.getId(),briteNode);
			// Sixth step: Starts the simulation
                        
			CloudSim.startSimulation();

			CloudSim.stopSimulation();
          
                        
                                  
			// Final step: Print results when simulation is over
			List<Cloudlet> newList = broker.getCloudletReceivedList();
                        
			//broker.submitCloudletList(newList);
                        printCloudletList(newList);
			Log.printLine("numberofcloudlet " + newList.size() + " Cached "
					+ NetDatacenterBroker.cachedcloudlet + " Data transfered "
					+ NetworkConstants.totaldatatransfer);
			// Print the debt of each user to each datacenter
			datacenter0.printDebts();
                        datacenter1.printDebts();
                        datacenter2.printDebts();
                        datacenter3.printDebts();
                        datacenter4.printDebts();
                        datacenter5.printDebts();
                        datacenter6.printDebts();
                        datacenter7.printDebts();

			Log.printLine("Datacenters intialization finished!");
             
                        
		} 
catch (Exception e) {
			
			Log.printLine();
		}
                CloudSim.stopSimulation();
    finish_broker=System.currentTimeMillis();
    exec_broker=finish_broker-starttime;
    Log.printLine("BROKER time: "+exec_broker );
    Log.printLine("Alg time : "+exec_alg);
    Chart_Exec.callchart(exec_broker,exec_alg);
    FlushDB flu=new FlushDB();
    flu.FlushDB();
    }

	/**
	 * Creates the datacenter.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the datacenter
	 */
	private static NetworkDatacenter createDatacenter(String name,int x) {

		// Here are the steps needed to create a PowerDatacenter:
		// 1. We need to create a list to store
		// our machine
    NetworkDatacenter datacenter = null;
    int hostid=0;
		List<NetworkHost> hostList = new ArrayList<NetworkHost>();

		// 2. A Machine contains one or more PEs or CPUs/Cores.
		// In this example, it will have only one core.
		// List<Pe> peList = new ArrayList<Pe>();
   double c=Math.random()*100;
                int d=(int) Math.ceil(c);             
  for(int r=0;r<x;r++)
  {   double a=Math.random()*100;
                int b=(int) Math.ceil(a);
      int[] r_mips ={1000,2000,3000};

		// 3. Create PEs and add these into a list.
		// peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to
		// store Pe id and MIPS Rating

		// 4. Create Host with its id and list of PEs and add them to the list
		// of machines
		int[] r_ram = {1024,2048,5096}; // host memory (MB)
		long[] r_storage = {1000000,200000,3000000}; // host storage
		int[] r_bw = {10000,20000,30000};
                int rmips=(int) b%3;
                int rram=(int) b%3;
                int rstorage=(int) b%3;
                int rbw=(int) b%3;
                int mips=r_mips[rmips];
                int ram=r_ram[rram];
                long storage=r_storage[rstorage];
                int bw=r_bw[rbw];
		for (int i = 0; i < NetworkConstants.EdgeSwitchPort * NetworkConstants.AggSwitchPort
				* NetworkConstants.RootSwitchPort; i++) {
			// 2. A Machine contains one or more PEs or CPUs/Cores.
			// In this example, it will have only one core.
			// 3. Create PEs and add these into an object of PowerPeList.
			List<Pe> peList = new ArrayList<Pe>();
			peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(1, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(2, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(3, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(4, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(5, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(6, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating
			peList.add(new Pe(7, new PeProvisionerSimple(mips))); // need to
			// store
			// PowerPe
			// id and
			// MIPS
			// Rating

			// 4. Create PowerHost with its id and list of PEs and add them to
			// the list of machines
			hostList.add(new NetworkHost(
					i,
					new RamProvisionerSimple(ram),
					new BwProvisionerSimple(bw),
					storage,
					peList,
					new VmSchedulerTimeShared(peList))); // This is our machine
		
                }
                

		// 5. Create a DatacenterCharacteristics object that stores the
		// properties of a data center: architecture, OS, list of
		// Machines, allocation policy: time- or space-shared, time zone
		// and its price (G$/Pe time unit).
                String[] r_arch = {"x86","x32","x16","x64"};
		//String arch = "x86"; // system architecture
		String[] r_os={"Linux","Windows","Chrome","Solaris","System Z"};
                //String os = "Linux";
                 // operating system
		String[] r_vmm={"Xen","SC","jasmine"};
                //String vmm = "Xen";
		double[] r_time_zone = {0.0,10.0,20.0}; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this
		// resource
		double costPerBw = 0.0; // the cost of using bw in this resource
                int rarch=(int) b%3;
                int ros=(int) b%4;
                int rvmm=(int) b%3;
                int rtime_zone=(int) b%3;
                String arch= r_arch[rarch];
                String os=r_os[ros];
                String vmm=r_vmm[rvmm];
                double time_zone=r_time_zone[rtime_zone];
                int pes=8;
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are
		// not
		// adding
		// SAN
		// devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
				arch,
				os,
				vmm,
				hostList,
				time_zone,
				cost,
				costPerMem,
				costPerStorage,
				costPerBw);

		// 6. Finally, we need to create a NetworkDatacenter object.
		
		try {
			datacenter = new NetworkDatacenter(
					name,
					characteristics,
					new NetworkVmAllocationPolicy(hostList),
					storageList,
					0);
                         Connection connect = null;
  Statement statement = null;
  PreparedStatement preparedStatement = null;
  ResultSet resultSet = null;
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud_rd","root","");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      Log.printLine("Adding host"+hostid+"to"+name+ " Updating CIS database");
      if(name=="Datacenter_2")
      {
     statement.executeUpdate("insert into zone_1 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }
      else if(name=="Datacenter_6")
      {
          statement.executeUpdate("insert into zone_1 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }
      else if(name=="Datacenter_3")
      {
          statement.executeUpdate("insert into zone_2 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }   
      else if(name=="Datacenter_7")
      {
          statement.executeUpdate("insert into zone_2 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }   
      else if(name=="Datacenter_0")
      {
          statement.executeUpdate("insert into zone_3 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }   
      else if(name=="Datacenter_4")
      {
          statement.executeUpdate("insert into zone_3 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }   
      else if(name=="Datacenter_1")
      {
          statement.executeUpdate("insert into zone_4 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }
      else 
      {
          statement.executeUpdate("insert into zone_4 values('"+name+"','"+hostid+"','"+mips+"','"+ram+"','"+storage+"','"+bw+"','"+pes+"','"+arch+"','"+os+"','"+vmm+"')");
      }   
      hostid++;
		} catch (Exception e) {
			return null;
		}
                
		// Create Internal Datacenter network
		CreateNetwork(8, datacenter);
}		return datacenter;
	}

	// submit vms and cloudlets according
	// to the specific rules of the simulated scenario
	/**
	 * Creates the broker.
	 * 
	 * @return the datacenter broker
	 */
	private static DatacenterBroker createBroker() {
		DatacenterBroker broker = null;
		try {
			broker = new DatacenterBroker("");
		} catch (Exception e) {
			
			return null;
		}
		return broker;
	}

	/**
	 * Prints the Cloudlet objects.
	 * 
	 * @param list
	 *            list of Cloudlets
	 * @throws IOException
	 */
	private static void printCloudletList(List<Cloudlet> list) throws IOException {
		int size = list.size();
		Cloudlet cloudlet;
		String indent = "    ";
		Log.printLine();
		Log.printLine("========== OUTPUT Cloudlets provisioned ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent + "Data center ID" + indent + "VM ID"
				+ indent + "Time" + indent + "Start Time" + indent + "Finish Time");

		DecimalFormat dft = new DecimalFormat("###.##");
		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("Cloudlet provision SUCCESS");
				Log.printLine(indent + indent + cloudlet.getResourceId() + indent + indent + indent
						+ cloudlet.getVmId() + indent + indent + dft.format(cloudlet.getActualCPUTime())
						+ indent + indent + dft.format(cloudlet.getExecStartTime()) + indent + indent
						+ dft.format(cloudlet.getFinishTime()));
			}
		}

	}

	static void CreateNetwork(int numhost, NetworkDatacenter dc) {

		// Edge Switch
		EdgeSwitch edgeswitch[] = new EdgeSwitch[1];

		for (int i = 0; i < 1; i++) {
			edgeswitch[i] = new EdgeSwitch("Edge" + i, NetworkConstants.EDGE_LEVEL, dc);
			// edgeswitch[i].uplinkswitches.add(null);
			dc.Switchlist.put(edgeswitch[i].getId(), edgeswitch[i]);
			// aggswitch[(int)
			// (i/Constants.AggSwitchPort)].downlinkswitches.add(edgeswitch[i]);
		}
		for (Host hs : dc.getHostList()) {
			NetworkHost hs1 = (NetworkHost) hs;
			hs1.bandwidth = NetworkConstants.BandWidthEdgeHost;
			int switchnum = (int) (hs.getId() / NetworkConstants.EdgeSwitchPort);
			edgeswitch[switchnum].hostlist.put(hs.getId(), hs1);
			dc.HostToSwitchid.put(hs.getId(), edgeswitch[switchnum].getId());
			hs1.sw = edgeswitch[switchnum];
			List<NetworkHost> hslist = hs1.sw.fintimelistHost.get(0D);
			if (hslist == null) {
				hslist = new ArrayList<NetworkHost>();
				hs1.sw.fintimelistHost.put(0D, hslist);
			}
			hslist.add(hs1);

		}

	}

        
}
    
    
