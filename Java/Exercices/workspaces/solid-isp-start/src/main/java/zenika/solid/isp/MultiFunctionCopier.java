package zenika.solid.isp;

public class MultiFunctionCopier implements Machine {

	@Override
	public void print() {
		System.out.println("Print pages");
	}

	@Override
	public void fax() {
		System.out.println("Fax pages");
	}

	@Override
	public void scan() {
		System.out.println("Scan pages");
	}

	@Override
	public void photocopy() {
		System.out.println("Photocopy pages");
	}

}
