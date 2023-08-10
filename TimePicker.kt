@Composable
fun ITimePicker(time : (String) -> Unit, showDialog : (Boolean) -> Unit ){

    var amOrPm by remember {
        mutableStateOf(AmPm.AM.name)
    }

    var hours by remember {
        mutableStateOf(12)
    }

    var minutes by remember {
        mutableStateOf(30)
    }

    Card(elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(1.dp, color = Color.Yellow)) {
        Box() {
            Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "SELECT TIME")
                Row(modifier = Modifier.padding(10.dp)) {
                    Button(onClick = { amOrPm = AmPm.AM.name },
                        shape = RoundedCornerShape(CornerSize(10.dp)), colors = ButtonDefaults.buttonColors(
                            containerColor = if (amOrPm == AmPm.AM.name){
                                Color.Green
                            }else{
                                Color.Gray
                            }
                        )) {
                        Text(text = AmPm.AM.name)
                    }
                    Button(onClick = { amOrPm = AmPm.PM.name },
                        shape = RoundedCornerShape(CornerSize(10.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor =
                        if (amOrPm == AmPm.PM.name){
                            Color.Green
                        }else{
                            Color.Gray
                        })) {
                        Text(text = AmPm.PM.name)
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                    Text(text = "HOURS : ")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "$hours")
                    Spacer(modifier = Modifier.width(17.dp))
                    Icon(painter = painterResource(id = R.drawable.remove) ,
                        contentDescription = "remove" ,
                        modifier = Modifier.clickable {
                            if (hours != 1){
                                hours -= 1
                            }
                        })
                    Icon(painter = painterResource(id = R.drawable.add) ,
                        contentDescription = "add" ,
                        modifier = Modifier.clickable {
                            if (hours < 12){
                                hours += 1
                            }
                        })
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
                    Text(text = "MINUTES : ")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "$minutes")
                    Spacer(modifier = Modifier.width(17.dp))
                    Icon(painter = painterResource(id = R.drawable.remove) ,
                        contentDescription = "remove" , modifier = Modifier.clickable {
                            if (minutes != 5){
                                minutes -= 5
                            }
                        })
                    Icon(painter = painterResource(id = R.drawable.add) ,
                        contentDescription = "add" , modifier = Modifier.clickable {
                            if (minutes < 56){
                                minutes += 5
                            }
                        })
                }
                IButtonWithoutContainer(imageVector = Icons.Outlined.Check) {
                    time("$hours : $minutes $amOrPm")
                    showDialog(false)
                }
            }
            IButtonWithoutContainer(imageVector = Icons.Outlined.Close, modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)) {
                 showDialog(false)
            }
        }
    }
}
