package fjnu.zjp.maven_hotel;


/*public class ListHome {

MainRun mr=new MainRun();

public void search() {
	//��ӡ�����
	for (int i=0;i<mr.getRoom().length;i++)
	{
		for(int j=0;j<mr.getRoom()[0].length;j++) {
			if(j+1<10) {
				System.out.print(i+1+"0"+(j+1)+"\t");
			}
			else {
				System.out.print(i+1+""+(j+1)+"\t");
			}
		}
		//��ӡ����״̬
		System.out.println();
		for (int j =0;j<mr.getRoom()[0].length;j++) 
		{
			System.out.print(mr.getRoom()[i][j]+'\t');
		} 
		System.out.println();
	}	
}
}*/
public class ListHome{
IData iData;
public ListHome(IData iData) {
	this.iData=iData;
}
public ListHome() {
	
}

public void search() {
	//��ӡ�����
	for (int i=0;i<HotelConstant.HOTEL_TOTAL_FlOOR;i++)
		{
			for(int j=0;j<HotelConstant.HOTEL_ROOMS_EVERYFlOOR;j++) {
				if(j+1<10) {
					System.out.print(i+1+"0"+(j+1)+"\t");
				}
				else {
					System.out.print(i+1+""+(j+1)+"\t");
				}
			}
			//��ӡ����״̬
			System.out.println();
			for (int j =0;j<HotelConstant.HOTEL_ROOMS_EVERYFlOOR;j++) 
			{
				System.out.print(iData.getStation((i+1)*100+j+1)+'\t');
			}
			System.out.println();
		}			
}

}

