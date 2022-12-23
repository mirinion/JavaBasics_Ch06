package Ex22;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Ex22 {

	/*
	Усовершенствуйте метод
	public static <V, Т> V doWork(Callable<V> с, T ex) throws T,
    представленный в разделе 6.6.7, таким образом, чтобы передавать ему объект исключения,
    который вряд ли будет вообще использован.
    Вместо этого данный метод должен принимать ссылку на класс исключения.
	 */

	public static void main(String[] args) {
		try {
			System.out.println(
					doWorkImproved(() -> "Called string from thread: " + Thread.currentThread().getName(),
							InterruptedException::new
					)
			);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public static <V, T extends Exception> V doWorkImproved(Callable<V> c, Supplier<T> exConstr)
			throws T {
		try {
			return c.call();
		} catch (Throwable realEx) {
			T exFromOuterConstr = exConstr.get();
			realEx.initCause(exFromOuterConstr);
			throw exFromOuterConstr;
		}
	}

	public static <V, T extends Exception> V doWorkOrig(Callable<V> c, T ex) throws T {
		try {
			return c.call();
		} catch (Throwable realEx) {
			ex.initCause(realEx);
			throw ex;
		}
	}


}
