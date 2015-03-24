import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;

import org.junit.Test;

import com.thoughtworks.paranamer.BytecodeReadingParanamer;

public class EmptyParameterLists {
	@Test
	public void testEmptyParameterShouldReturnAnEmptyArray() throws Exception {
		BytecodeReadingParanamer paranamer = new BytecodeReadingParanamer();
		Class<NoArgs> cls = NoArgs.class;
		
		Method method = cls.getMethod("foo", new Class<?>[]{});
		String[] methNames = paranamer.lookupParameterNames(method);
		assertEquals(0, methNames.length); //Failure here!
	}
}

class NoArgs {
	public void foo() {}
}
