package com.hardcodecoder.pulsemusic.providers;

import android.os.Handler;

import androidx.annotation.NonNull;

import com.hardcodecoder.pulsemusic.TaskRunner;
import com.hardcodecoder.pulsemusic.TaskRunner.Callback;
import com.hardcodecoder.pulsemusic.helper.DataModelHelper;
import com.hardcodecoder.pulsemusic.model.MusicModel;
import com.hardcodecoder.pulsemusic.utils.StorageUtil;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoritesProvider {

    private final Handler mHandler;
    private final String mFavoritesFilePath;
    private Set<Integer> mFavoritesSet;

    public FavoritesProvider(String baseDir, Handler handler) {
        mHandler = handler;
        mFavoritesFilePath = baseDir + File.separator + "favorites.txt";
        StorageUtil.createFile(new File(mFavoritesFilePath));
    }

    public void addToFavorites(@NonNull MusicModel musicModel) {
        if (musicModel.getId() < 0) return;
        TaskRunner.executeAsync(() -> {
            loadFavorites();
            if (mFavoritesSet.add(musicModel.getId()))
                StorageUtil.writeStringToFile(
                        new File(mFavoritesFilePath),
                        musicModel.getId() + System.lineSeparator(),
                        true);
        });
    }

    public void isTemFavorite(MusicModel musicModel, Callback<Boolean> callback) {
        TaskRunner.executeAsync(() -> {
            loadFavorites();
            if (mFavoritesSet.contains(musicModel.getId()))
                mHandler.post(() -> callback.onComplete(true));
            else mHandler.post(() -> callback.onComplete(false));
        });
    }

    public void getFavoriteTracks(Callback<List<MusicModel>> callback) {
        TaskRunner.executeAsync(() -> {
            File file = new File(mFavoritesFilePath);
            if (file.exists()) {
                List<Integer> trackIds = StorageUtil.readPlaylistIdsFromFile(file);
                List<MusicModel> favoriteTracks = DataModelHelper.getModelObjectFromId(trackIds);
                mHandler.post(() -> callback.onComplete(favoriteTracks));
            } else mHandler.post(() -> callback.onComplete(null));
        });
    }

    public void removeFromFavorite(@NonNull MusicModel musicModel) {
        TaskRunner.executeAsync(() -> {
            File file = new File(mFavoritesFilePath);
            Integer id = musicModel.getId();
            loadFavorites();
            if (mFavoritesSet.remove(id)) {
                List<Integer> trackIds = StorageUtil.readPlaylistIdsFromFile(file);
                trackIds.remove(id);
                StorageUtil.writePlaylistIdsToFile(file, trackIds, false);
            }
        });
    }

    public void clearAllFavorites() {
        TaskRunner.executeAsync(() -> {
            StorageUtil.deleteFile(new File(mFavoritesFilePath));
            if (null != mFavoritesSet) mFavoritesSet.clear();
        });
    }

    private synchronized void loadFavorites() {
        if (null != mFavoritesSet) return;
        File file = new File(mFavoritesFilePath);
        List<Integer> favoriteRecords = null;
        if (file.exists())
            favoriteRecords = StorageUtil.readPlaylistIdsFromFile(file);
        mFavoritesSet = new HashSet<>();
        if (null != favoriteRecords)
            mFavoritesSet.addAll(favoriteRecords);
    }
}