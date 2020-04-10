package fjnu.zjp.maven_hotel;

public class DP implements IData{
	private static String[][] rooms;
	 
	MainRun mr=new MainRun();
	
	public void iniRooms() {
		// TODO Auto-generated method stub
		rooms=new String[HotelConstant.HOTEL_TOTAL_FlOOR]
				[HotelConstant.HOTEL_ROOMS_EVERYFlOOR];
		for (int i=0;i<rooms.length;i++)
		{
			for(int j=0;j<rooms[0].length;j++) {
				rooms[i][j]=HotelConstant.EMPTY;
			}
		}
	}
	public String getStation(int roomNo) {
		return rooms[(roomNo/100)-1][(roomNo%100)-1];
	}
	public int roomNo(int roomNo) {
		if(HotelConstant.EMPTY.equals(rooms[(roomNo/100)-1][(roomNo%100)-1])) {
			return roomNo;
		}
		else
			return 0;
	}
	public String in_Out_Room(int roomNo, String name) {
		if(name.equals(HotelConstant.EMPTY)) {
			if(roomNo(roomNo)==0)
			{
				rooms[(roomNo/100)-1][(roomNo%100)-1]=name;
				return roomNo+"�˷��ɹ���";
			}
			else
				return "�÷���û�п�����ס���˷�ʧ�ܣ�";
		}
		else if(roomNo(roomNo)==0)
		{
			return "�÷����Ѿ��п�����ס��";
		}
		else
		{
			rooms[(roomNo/100)-1][(roomNo%100)-1]=name;
			return name+"�ɹ���ס"+roomNo+"���䣡";
		}
	}
	
	

	

}
