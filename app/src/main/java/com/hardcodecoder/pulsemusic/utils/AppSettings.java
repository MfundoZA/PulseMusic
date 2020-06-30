package com.hardcodecoder.pulsemusic.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.hardcodecoder.pulsemusic.Preferences;

public class AppSettings {

    public static void savePortraitModeGridSpanCount(@NonNull Context context, String prefId, int count) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.SPAN_COUNT, Context.MODE_PRIVATE).edit();
        editor.putInt(prefId, count);
        editor.apply();
    }

    public static int getPortraitModeGridSpanCount(@NonNull Context context, String prefId) {
        return context.getSharedPreferences(Preferences.SPAN_COUNT, Context.MODE_PRIVATE)
                .getInt(prefId, Preferences.SPAN_COUNT_PORTRAIT_DEF_VALUE);
    }

    public static void saveLandscapeModeGridSpanCount(@NonNull Context context, String prefId, int count) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.SPAN_COUNT, Context.MODE_PRIVATE).edit();
        editor.putInt(prefId, count);
        editor.apply();
    }

    public static int getLandscapeModeGridSpanCount(@NonNull Context context, String prefId) {
        return context.getSharedPreferences(Preferences.SPAN_COUNT, Context.MODE_PRIVATE)
                .getInt(prefId, Preferences.SPAN_COUNT_LANDSCAPE_DEF_VALUE);
    }

    public static void saveSortOrder(@NonNull Context context, String prefId, int sortOrder) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.SORT_ORDER_PREFS_KEY, Context.MODE_PRIVATE).edit();
        editor.putInt(prefId, sortOrder);
        editor.apply();
    }

    public static int getSortOrder(@NonNull Context context, String prefId) {
        return context.getSharedPreferences(Preferences.SORT_ORDER_PREFS_KEY, Context.MODE_PRIVATE)
                .getInt(prefId, Preferences.SORT_ORDER_ASC);
    }

    public static void enableDarkMode(@NonNull Context context, boolean state) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.UI_THEME_DARK_KEY, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Preferences.UI_THEME_DARK_KEY, state);
        editor.apply();
    }

    public static void enableAutoTheme(@NonNull Context context, boolean state) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.UI_MODE_AUTO_KEY, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Preferences.UI_MODE_AUTO_KEY, state);
        editor.apply();
    }

    public static boolean isDarkModeEnabled(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.UI_THEME_DARK_KEY, Context.MODE_PRIVATE).getBoolean(Preferences.UI_THEME_DARK_KEY, false);
    }

    public static boolean isAutoThemeEnabled(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.UI_MODE_AUTO_KEY, Context.MODE_PRIVATE).getBoolean(Preferences.UI_MODE_AUTO_KEY, false);
    }

    public static void saveSelectedDarkTheme(@NonNull Context context, int id) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.DARK_THEME_CATEGORY_KEY, Context.MODE_PRIVATE).edit();
        editor.putInt(Preferences.DARK_THEME_CATEGORY_KEY, id);
        editor.apply();
    }

    public static int getSelectedDarkTheme(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.DARK_THEME_CATEGORY_KEY, Context.MODE_PRIVATE)
                .getInt(Preferences.DARK_THEME_CATEGORY_KEY, Preferences.DARK_THEME_GRAY);
    }

    public static void saveSelectedAccentId(@NonNull Context context, int accentId) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.ACCENTS_COLOR_KEY, Context.MODE_PRIVATE).edit();
        editor.putInt(Preferences.ACCENTS_COLOR_KEY, accentId);
        editor.apply();
    }

    public static int getSelectedAccentId(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.ACCENTS_COLOR_KEY, Context.MODE_PRIVATE)
                .getInt(Preferences.ACCENTS_COLOR_KEY, Preferences.ACCENT_EXODUS_FRUIT);
    }

    public static void saveAccentDesaturatedColor(@NonNull Context context, boolean enabled) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.ACCENTS_COLOR_DESATURATED_KEY, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Preferences.ACCENTS_COLOR_DESATURATED_KEY, enabled);
        editor.apply();
    }

    public static boolean getAccentDesaturatedColor(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.ACCENTS_COLOR_DESATURATED_KEY, Context.MODE_PRIVATE)
                .getBoolean(Preferences.ACCENTS_COLOR_DESATURATED_KEY, false);
    }

    public static void setAlbumCardOverlayEnabled(@NonNull Context context, boolean enabled) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.ALBUM_CARD_OVERLAY_KEY, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Preferences.ALBUM_CARD_OVERLAY_KEY, enabled);
        editor.apply();
    }

    public static boolean isAlbumCardOverlayEnabled(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.ALBUM_CARD_OVERLAY_KEY, Context.MODE_PRIVATE)
                .getBoolean(Preferences.ALBUM_CARD_OVERLAY_KEY, false);
    }

    public static void setNowPlayingAlbumCardStyle(@NonNull Context context, int id) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.NOW_PLAYING_ALBUM_CARD_STYLE_KEY, Context.MODE_PRIVATE).edit();
        editor.putInt(Preferences.NOW_PLAYING_ALBUM_CARD_STYLE_KEY, id);
        editor.apply();
    }

    public static void setNowPlayingAlbumCardOverlayEnabled(@NonNull Context context, boolean enabled) {
        SharedPreferences.Editor editor = context.getSharedPreferences(Preferences.NOW_PLAYING_ALBUM_CARD_OVERLAY_KEY, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Preferences.NOW_PLAYING_ALBUM_CARD_OVERLAY_KEY, enabled);
        editor.apply();
    }

    public static int getNowPlayingAlbumCardStyle(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.NOW_PLAYING_ALBUM_CARD_STYLE_KEY, Context.MODE_PRIVATE)
                .getInt(Preferences.NOW_PLAYING_ALBUM_CARD_STYLE_KEY, Preferences.NOW_PLAYING_ALBUM_CARD_STYLE_SQUARE);
    }

    public static boolean isNowPlayingAlbumCardOverlayEnabled(@NonNull Context context) {
        return context.getSharedPreferences(Preferences.NOW_PLAYING_ALBUM_CARD_OVERLAY_KEY, Context.MODE_PRIVATE)
                .getBoolean(Preferences.NOW_PLAYING_ALBUM_CARD_OVERLAY_KEY, false);
    }
}
