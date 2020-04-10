package fjnu.zjp.maven_hotel;

import static junit.framework.Assert.assertEquals;

import org.easymock.EasyMock;

import junit.framework.Test;





public class ListHometestEasyMock {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	private IData iData = null;

	@Test
	public void testSearchwhenALLRoomIsEmpty() {
		
		iData = EasyMock.createMock(IData.class);
		
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FlOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) 
			{
				EasyMock.expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);

			}
		}		
		EasyMock.replay(iData);
		
		ListHome lh = new ListHome(iData);
		lh.search();
		
		String lineSeparator = System.getProperty("line.separator");
		
		StringBuilder sb = new StringBuilder();
		// ��ӡ�����
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FlOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) {
				if (j + 1 < 10) {
					sb.append(i+1+"0"+(j + 1)+"\t");
				} else {
					sb.append(i+1+""+(j + 1)+"\t");
				}
			}
			// ��ӡ����״̬
			sb.append(lineSeparator);

			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) {
				sb.append(HotelConstant.EMPTY+"\t");
			}
			sb.append(lineSeparator);
		}
		
		assertEquals(sb.toString(), systemOutRule.getLog());
		EasyMock.verify(iData);

	}
	
	@Test
	public void testSearchwhenALLRoomIsnotEmpty() {
		
		iData = EasyMock.createMock(IData.class);
		
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FlOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) 
			{
				if((i==0)&&(j==0)) {
					EasyMock.expect(iData.getStation(101)).andReturn("����");	
				}
				else
				{
					EasyMock.expect(iData.getStation((i+1)*100+j+1)).andReturn(HotelConstant.EMPTY);
				}
				

			}
		}
		EasyMock.replay(iData);
		ListHome lh = new ListHome(iData);
		lh.search();
		String lineSeparator = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		// ��ӡ�����
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FlOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) {
				
				if (j + 1 < 10) {
					
					sb.append(i+1+"0"+(j + 1)+"\t");
				} else {
					sb.append(i+1+""+(j + 1)+"\t");
				}
			}
			// ��ӡ����״̬
			sb.append(lineSeparator);

			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFlOOR; j++) {
				if((i==0)&&(j==0)) 
				{
					sb.append("����"+'\t');
				}
				else
					
					sb.append(HotelConstant.EMPTY+"\t");
			}
			sb.append(lineSeparator);
		}
		assertEquals(sb.toString(), systemOutRule.getLog());
		EasyMock.verify(iData);

	}
}