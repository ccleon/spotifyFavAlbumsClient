package cori.spotifyapi_client;

import android.provider.BaseColumns;

/**
 * Created by Cori on 9/11/16.
 */

public class Contract {
    public Contract(){
    }

    public static class tablaAlbum implements BaseColumns {
        public static final String TABLE_NAME = "albumcomentar";
        public static final String COL_NAME_ID = _ID;
        public static final String COL_NAME_NAME = "name";
        public static final String COL_NAME_TYPE = "type";
        public static final String COL_NAME_IMAGE = "image";
        public static final String COL_NAME_OPINION = "opinion";
        public static final String COL_NAME_CAL = "cal";

    }

}
