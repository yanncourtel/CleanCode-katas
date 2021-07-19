package zenika.solid.isp;

public class SimplePrinter implements Machine {

	@Override
	public void print() {
		System.out.println("Print pages");
	}

	@Override
	public void fax() {
		throw new UnsupportedOperationException("Can't fax");
	}

	@Override
	public void scan() {
		throw new UnsupportedOperationException("Can't scan");
	}

	@Override
	public void photocopy() {
		throw new UnsupportedOperationException("Can't photocopy");
	}

}
