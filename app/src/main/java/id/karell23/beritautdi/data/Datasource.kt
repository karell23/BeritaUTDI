package id.karell23.beritautdi.data
import id.karell23.beritautdi.model.Berita
import id.karell23.beritautdi.R

class Datasource() {
    fun loadBeritas(): List<Berita> {
        return listOf<Berita>(
            return listOf<Berita>(
                Berita(R.string.berita1, R.drawable.image1),
                Berita(R.string.berita2, R.drawable.image2),
                Berita(R.string.berita3, R.drawable.image3),
                Berita(R.string.berita4, R.drawable.image4),
                Berita(R.string.berita5, R.drawable.image5))
        )
    }
}
