package Ex14;

public class MyAutoCloseable implements AutoCloseable {
	final String resName;

	public MyAutoCloseable(String resName) {
		this.resName = resName;
	}

	@Override
	public void close() throws Exception{
		throw new Exception("Exception while closing " + resName);
	}
}
