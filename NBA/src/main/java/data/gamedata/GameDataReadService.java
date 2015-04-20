package data.gamedata;

import java.io.File;

public interface GameDataReadService {

	public GameInfo readMatchFile(File f);
}
