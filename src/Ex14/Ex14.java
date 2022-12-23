package Ex14;

import java.util.ArrayList;

public class Ex14 {
	public static void main(String[] args) {
		ArrayList<MyAutoCloseable> autoCloseableArrayList = new ArrayList<>();
		autoCloseableArrayList.add(new MyAutoCloseable("first res"));
		autoCloseableArrayList.add(new MyAutoCloseable("second res"));
		autoCloseableArrayList.add(new MyAutoCloseable("third res"));

		try {
			closeAll(autoCloseableArrayList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems)
		throws Exception {
		Exception lastEx = null;
		for (T elem : elems) {
			try {
				elem.close();
			} catch (Exception ex) {
				if (lastEx != null) {
					//по заданию надо связывать в цепочку
					//иначе я бы подавлял все под общее исключение
					ex.initCause(lastEx);
				}
				lastEx = ex;
			}
		}

		if (lastEx != null) {
			throw lastEx;
		}
	}
}
