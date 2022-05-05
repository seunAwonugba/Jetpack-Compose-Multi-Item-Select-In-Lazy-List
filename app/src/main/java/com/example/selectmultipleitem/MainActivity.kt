package com.example.selectmultipleitem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.selectmultipleitem.ui.theme.Purple200
import com.example.selectmultipleitem.ui.theme.SelectMultipleItemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SelectMultipleItemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()

                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    val repository = LazyItemRepository()
    val fetchAllData = repository.getAllData()

    var selectedItems by remember{
        mutableStateOf(setOf<Int>())
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Select Multiple Items",
            fontSize = 24.sp
        )
    }
    
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ){
        itemsIndexed(items = fetchAllData){ index, myListItem ->
            val checked = selectedItems.contains(index)
            SingleItemCard(
                lazyItemData = myListItem,
                checkedValue = checked,
                onCheckChanged = {
                    selectedItems = if (checked){
                        selectedItems - index
                    }else{
                        selectedItems +index
                    }
                }
            )
        }
    }
}

@Composable
fun SingleItemCard(
    lazyItemData: LazyItemData,
    checkedValue : Boolean,
    onCheckChanged : (Boolean) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 16.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = lazyItemData.id)
            Column {
                Text(text = lazyItemData.firstName)
                Text(text = lazyItemData.lastName)
                Text(text = lazyItemData.age.toString())
            }
            Checkbox(
                checked = checkedValue,
                onCheckedChange =onCheckChanged,
                colors = CheckboxDefaults.colors(Purple200)
            )
        }
    }
}