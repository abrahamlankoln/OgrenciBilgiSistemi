
public class Student {
	String name, stuNo;
	int classes;
	Course mat;
	Course fizik;
	Course kimya;
	double avarage;
	boolean isPass;

	Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
		this.name = name;
		this.classes = classes;
		this.stuNo = stuNo;
		this.mat = mat;
		this.fizik = fizik;
		this.kimya = kimya;
		calcAvarage();
		this.isPass = false;
	}

	public void addBulkExamNote(int mat, int matsoz, int fizik, int fiziksoz, int kimya, int kimyasoz) {

		if (mat >= 0 && mat <= 100) {
			this.mat.note = mat;
		}

		if (fizik >= 0 && fizik <= 100) {
			this.fizik.note = fizik;
		}

		if (kimya >= 0 && kimya <= 100) {
			this.kimya.note = kimya;
		}
		if (matsoz >= 0 && matsoz <= 100) {
			this.mat.sozlu = matsoz;
		}

		if (fiziksoz >= 0 && fiziksoz <= 100) {
			this.fizik.sozlu = fiziksoz;
		}

		if (kimyasoz >= 0 && kimyasoz <= 100) {
			this.kimya.sozlu = kimyasoz;
		}

	}

	public void isPass() {
		if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0||this.mat.sozlu==0||this.fizik.sozlu==0||this.kimya.sozlu==0) {
			System.out.println("Notlar tam olarak girilmemiş");
		} else {
			this.isPass = isCheckPass();
			printNote();
			System.out.println("Ortalama : " + this.avarage);
			if (this.isPass) {
				System.out.println("Sınıfı Geçti. ");
			} else {
				System.out.println("Sınıfta Kaldı.");
			}
		}
	}

	public void calcAvarage() {
		this.avarage = (this.fizik.note*0.8+this.fizik.sozlu*0.2 + this.kimya.note*0.8+this.kimya.sozlu*0.2 + this.mat.note*0.8+this.mat.sozlu*0.2) / 3;
	}

	public boolean isCheckPass() {
		calcAvarage();
		return this.avarage > 55;
	}

	public void printNote() {
		System.out.println("=========================");
		System.out.println("Öğrenci : " + this.name);
		System.out.println("Matematik Sinav Notu : " + this.mat.note);
		System.out.println("Matematik Sozlu Notu : " + this.mat.sozlu);
		System.out.println("Fizik Sinav Notu : " + this.fizik.note);
		System.out.println("Fizik Sozlu Notu : " + this.fizik.sozlu);
		System.out.println("Kimya Sinav Notu : " + this.kimya.note);
		System.out.println("Kimya Sozlu Notu : " + this.kimya.sozlu);
	}
}
