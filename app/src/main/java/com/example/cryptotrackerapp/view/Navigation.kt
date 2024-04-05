package com.example.cryptotrackerapp.view

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(navController: NavHostController){
    Column(
        verticalArrangement = Arrangement.Center
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Text("Home Screen")
        Spacer(modifier = Modifier.size(20.dp))
        Button(onClick={
            navController.navigate(BottomNavItem.Favourites.route)
        }
        ){
            Text ("Go to favourites")
        }
    }
}

@Composable
fun Favourites(){
    Box (
        contentAligment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Text("Favourites Screen")
    }

}

@Composable
fun Profile(){
    Box (
        contentAligment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Text("Profile Screen")
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route){
        composable(BottomNavItem.Home.route){ HomeScreen()}
        composable(BottomNavItem.Favourites.route){ FavouritesScreen()}
        composable(BottomNavItem.Profile.route){ ProfileScreen()}

    }
}

@SupressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {BottomTabBar(navController = navController)}
    ){
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomTabBar(navController: NavHostController){
    val tabBarItems = ListOf(
        BottomNavItem.Home,
        BottomNavItem.Favourites,
        BottomNavItem.Profile
    )
    BottomAppBar{
        val navBackStack by navController.currentBackStackEntryAsState() //Recuerda estado actual
        val currentRoute = navBackStack?.destination?.route

        tabBarITems.forEach{barItem ->
            val isSelected = currentRoute == barItem.route
            NavigationBarITem(
                selected = isSelected,
                label = {
                    Text(text = barItem.title)
                },
                onClick = {
                    navController.navigate(barItem.route)
                },
                icon = {
                    Icon(
                        imageVector = if (isSelected) barItem.selectedIcon else barItem.unselectedIcon,
                        contentDescription = barItem.title
                    )
                }
            )
        }
    }
}
@Preview(showBackground = True, showSystemUI = true)
@Composable
fun PreviewMain(){
    MainScreen()
}