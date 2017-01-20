package idea.analyzesystem.hover.pinnedsection;

import java.io.Serializable;
import java.util.ArrayList;

public class BasePinnedSectionBean implements Serializable {

	public static final int ITEM = 0;
	public static final int SECTION = 1;

	private int type = ITEM;

	private String name;

	private int imageRes;

	public int getImageRes() {
		return imageRes;
	}

	public void setImageRes(int imageRes) {
		this.imageRes = imageRes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BasePinnedSectionBean{" +
				"type=" + type +
				'}';
	}
}
