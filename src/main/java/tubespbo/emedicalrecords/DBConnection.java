package tubespbo.emedicalrecords;

import java.sql.Connection;

public interface DBConnection {
    // membuat koneksi dengan DB untuk setiap 1 model 1 table
    DButil connectNow = new DButil();
    Connection connectDB = connectNow.getConnection();



    public default void sqlread() {
        // membaca semua pada tabel dari model tersebut
    }
}
