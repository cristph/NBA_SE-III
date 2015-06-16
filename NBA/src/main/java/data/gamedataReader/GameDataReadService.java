package data.gamedataReader;

import java.io.File;

import data.gamedata.GameInfo;

public interface GameDataReadService {

	public GameInfo readMatchFile(File f);
}
