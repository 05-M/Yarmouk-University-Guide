
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.School
import androidx.lifecycle.ViewModel


data class Feature(
    val title: String,
    val icon: ImageVector,
    val route: String // <<< إضافة جديدة: هنحدد المسار اللي كل كارت هيروح له
)
class HomeActivity: ViewModel