package edu.ailyn.a10days_

//AILYN DIAZ AIMS.EDU PROJECT I MADE FOR CLASS 3/23/24
// 10 - Days Assignment
// Kotlin / Android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import edu.ailyn.a10days_.ui.theme._10days_Theme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

//data class to represent a skateboarding tip
data class SkateboardingTip(
    val title: String,
    val description: String,
    val imageUrl: Int, // Resource ID for image
    val dayNumber: Int
)

// list of skateboarding tips
val skateboardingTips = listOf(
    SkateboardingTip(
        "Mastering the Ollie",
        "The ollie is the fundamental trick in skateboarding. " +
                "Learn how to pop your board and slide your front foot to level out in mid-air.",
        R.drawable.ollie,
        1 // Day 1
    ),
    SkateboardingTip(
        "Spot Finder",
        "Discover skate spots in your area and around the world, including skate parks, street spots, DIY spots, and hidden gems. ",
        R.drawable.skatepark,
        2 // Day 2
    ),
    SkateboardingTip(
        "Pick the Right Skate Shoes",
        "Skate shoes play a crucial role in your performance and safety. " +
                "Look for durable materials, good grip, and ankle support.",
        R.drawable.shoes,
        3 // Day 3
    ),
    SkateboardingTip(
        "Skateboard Setup Guides",
        "Setting up your skateboard correctly is essential for optimal performance and safety. " +
                "Make sure that what you end up choosing is what you love and enjoy. ",
        R.drawable.sitdown,
        4 // Day 4
    ),
    SkateboardingTip(
        "Skateboarding Culture & History",
        "Surfers in California wanted to replicate the feeling of riding waves on land, so they began experimenting. These \"sidewalk surfers\" let riders mimic surfing movements on the streets.",
        R.drawable.riding,
        5 // Day 5
    ),
    SkateboardingTip(
        "Safety & Injury Prevention",
        "Learn skateboarding safety, injury prevention, warm-up exercises, and first aid techniques. " +
                "To skate responsibly and minimize the risk of accidents.",
        R.drawable.gear,
        6 // Day 6
    ),
    SkateboardingTip(
        "Skateboarding Dictionary",
        "Brush up on skateboarding terminology with some of the jargon used here's a few things for the day; Pop, Manual, Fakie, and Switch.",
        R.drawable.chitchat,
        7 // Day 7
    ),
    SkateboardingTip(
        "Skate Stance",
        "Mastering your skateboarding stance is the first step in learning to skate. " +
                "Find out if you're regular or goofy, find your most comfortable position on the board.",
        R.drawable.standhold,
        8 // Day 8
    ),
    SkateboardingTip(
        "Dropping In",
        "A very fundamental skill for riding ramps and bowls. " +
                "The proper technique for dropping in safely and confidently is to start small then have fun movin' up!.",
        R.drawable.dropin,
        9 // Day 9
    ),
    SkateboardingTip(
        "Flip Tricks",
        "Flip tricks are advanced maneuvers that involve flipping and spinning the board. " +
                "Start with basic flip tricks like kickflips and heelflips. Knowing the Ollie is almost crucial.",
        R.drawable.kickflip,
        10 // Day 10
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _10days_Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(32.dp))
                        HeaderImage()
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "10 DAYS OF SKATEBOARDING TIPS",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            letterSpacing = 1.5.sp,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )

                        Text(
                            text = "If you're a seasoned skater or just getting started, this app is designed to inspire & educate all skateboarders worldwide.",
                            fontSize = 15.sp,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(Color.Cyan, Color.Yellow)
                                    )
                                )
                                .padding(vertical = 8.dp, horizontal = 16.dp)
                                .shadow(
                                    elevation = 4.dp,
                                    shape = MaterialTheme.shapes.medium,

                                )
                        )

                        Spacer(modifier = Modifier.height(32.dp))
                        SkateboardingTipsList(skateboardingTips)
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderImage() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f), Color.Transparent)
    val animatedGradient by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 5000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.groupskaterkids),
            contentDescription = "Header Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Brush.horizontalGradient(colors, startX = animatedGradient, endX = animatedGradient + 500f))
        )
    }
}

@Composable
fun SkateboardingTipCard(skateboardingTip: SkateboardingTip) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        color = Color.Cyan,
        shape = RoundedCornerShape(16.dp)
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Day ${skateboardingTip.dayNumber}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = skateboardingTip.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = if (expanded) 8.dp else 16.dp)
                )
                if (expanded) {
                    Text(
                        text = skateboardingTip.description,
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                Image(
                    painter = painterResource(id = skateboardingTip.imageUrl),
                    contentDescription = "Skateboarding tip image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(top = if (expanded) 8.dp else 0.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSkateboardingTipCard() {
    _10days_Theme {

    }
}

@Composable
fun SkateboardingTipsList(skateboardingTips: List<SkateboardingTip>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(skateboardingTips) { _, tip ->
            val animatedVisibilityState = remember { mutableStateOf(false) }
            LaunchedEffect(key1 = true) {
                animatedVisibilityState.value = true
            }
            AnimatedVisibility(
                visible = animatedVisibilityState.value,
                enter = slideInVertically(
                    initialOffsetY = { -100 }
                ) + fadeIn() + scaleIn(initialScale = 0.99f),
                exit = fadeOut()
            ) {
                SkateboardingTipCard(skateboardingTip = tip)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview1() {
    _10days_Theme {
        SkateboardingTipsList(skateboardingTips)
    }
}
