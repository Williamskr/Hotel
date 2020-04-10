package fjnu.zjp.maven_hotel;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;


public class OutHotelTest {
	private Mockery context=new Mockery();
	private IData iData=null;
	private OutHotel oh=null;
	@Before
	public void setUp() throws Exception{
		//��Mockeryʵ��������һ��ģ���IData����
		iData=context.mock(IData.class);
		oh=new OutHotel(iData);
		context.checking(new Expectations(){{
			oneOf(iData).in_Out_Room(701, "EMPTY");
			will(returnValue("701 �˷��ɹ���"));
		}});
	}
	@Test
	public void testOut() {
		assertEquals("701 �˷��ɹ���", oh.out(701));
	}
}
