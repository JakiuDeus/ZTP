package pl.wipb.ztp.ps4;

import java.util.UUID;

// prosta implementacja danych - tablica
class RealData implements Data {

	private final UUID id;
	private final int[] realData;

	public RealData(int size) {
		id = UUID.randomUUID();
		if (size <= 0) {
			throw new IllegalArgumentException("" + size);
		}
		realData = new int[size];
	}

	public int get(int idx) {
		if (idx < 0 || idx >= realData.length) {
			throw new ArrayIndexOutOfBoundsException("" + idx);
		}
		return realData[idx];
	}

	public void set(int idx, int value) {
		if (idx < 0 || idx >= realData.length) {
			throw new ArrayIndexOutOfBoundsException("" + idx);
		}
		realData[idx] = value;
		
	}

	public int size() {
		return realData.length;
	}

	@Override
	public String toString() {
		return "Tablica o rozmiarze " + realData.length + ", UUID: " + id;
	}
}