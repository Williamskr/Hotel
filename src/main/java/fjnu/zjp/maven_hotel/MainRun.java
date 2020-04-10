package fjnu.zjp.maven_hotel;

import java.util.Scanner;


public class MainRun {
	private static String[][] rooms;
	private static ListHome lh=new ListHome();
	private static InHotel ih=new InHotel();
	private static OutHotel oh=new OutHotel();
	private static Scanner sca;
	public static void main(String arg[]) {
		iniRooms();
		command();
	}
	private static void iniRooms() {
		rooms=new String[10][12];
		for (int i=0;i<rooms.length;i++)
		{
			for(int j=0;j<rooms[0].length;j++)
			{
				rooms[i][j]="EMPTY";
			}
		}
	}
	public static void command() {
		String comm;
		while(true) {
			System.out.println("���������");
			sca = new Scanner(System.in);
			System.gc();
			comm=sca.next();
			if("search".equalsIgnoreCase(comm)) {
				lh.search();
			}
			else if("in".equalsIgnoreCase(comm)) {
				int roomNo=sca.nextInt();
				try {
					if(valisRoomNo(roomNo)) {
						String name=sca.next();
						System.out.println(ih.in(roomNo,name));
					}else {
						System.out.println("����Ŵ�");
					}
				}catch (Exception e) {
					System.out.println("����Ŵ�");
				}
			}else if("out".equalsIgnoreCase(comm))
			{
				int roomNo=sca.nextInt();
				if(valisRoomNo(roomNo)) {
					System.out.println(oh.out(roomNo));
				}else
					System.out.println("����Ŵ�");
			}else if("exit".equalsIgnoreCase(comm)) {
				System.out.println("�����˳�");
				break;
			}else {
				System.out.println("��������������������룺");
			}
		}
	}
	private static boolean valisRoomNo(int roomNo) {
		// TODO Auto-generated method stub
		if((roomNo/100>10)||(roomNo/100<1)||(roomNo%100>12)||(roomNo%100<1))
			return false;
		else
			return true;
	}
	public String[][] getRoom(){
		return rooms;
	}


}