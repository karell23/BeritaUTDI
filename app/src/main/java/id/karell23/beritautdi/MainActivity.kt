package id.karell23.beritautdi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.karell23.beritautdi.data.Datasource
import id.karell23.beritautdi.model.Berita
import id.karell23.beritautdi.ui.theme.BeritaUTDITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeritaApp()
        }
    }
}

@Composable
fun BeritaApp() {
    BeritaUTDITheme {
        BeritaList(beritaList = Datasource().loadBeritas())
    }
}

@Composable
fun BeritaList(beritaList: List<Berita>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(beritaList) { berita ->
            BeritaCard(berita)
        }
    }
}

@Composable
fun BeritaCard(berita: Berita, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp) {
        Column {
            Image(
                painter = painterResource(berita.imageResourceId),
                contentDescription = stringResource(berita.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(berita.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview
@Composable
private fun BeritaCardPreview() {
    BeritaCard (Berita(R.string.berita1, R.drawable.image1))
}