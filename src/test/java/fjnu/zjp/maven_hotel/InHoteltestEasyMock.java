package fjnu.zjp.maven_hotel;

import static junit.framework.Assert.assertEquals;

import org.easymock.EasyMock;


public class InHoteltestEasyMock {

	private IData iData=null;
	
	public void testInsuccess() {
		iData = EasyMock.createMock(IData.class);
		EasyMock.expect(iData.in_Out_Room(101," ݼ��")).andReturn("ݼ�³ɹ���ס101���䣡");
		
		EasyMock.replay(iData);
		
		InHotel inHotel = new InHotel(iData);
		String result = inHotel.in(101, "ݼ��");
		
		assertEquals("ݼ�³ɹ���ס101���䣡", result);
		
		EasyMock.verify(iData);
	}
	
	
	public void testInFailure() {
		iData = EasyMock.createMock(IData.class);
		
		EasyMock.expect(iData.in_Out_Room(101, "ݼ��")).andReturn("�÷����Ѿ��п�����ס��");
		
		EasyMock.replay(iData);
		
		InHotel inHotel= new InHotel(iData);
		assertEquals(inHotel.in(101, "ݼ��"), "�÷����Ѿ��п�����ס��");
		
		EasyMock.verify(iData);
	}
	
}
