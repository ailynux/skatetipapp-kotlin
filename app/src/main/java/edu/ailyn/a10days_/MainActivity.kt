package edu.ailyn.a10days_
//AILYN DIAZ AIMS.EDU PROJECT I MADE FOR CLASS 3/26/24
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.tooling.preview.Preview // Importing Preview annotation
import edu.ailyn.a10days_.ui.theme._10days_Theme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

// Define a data class to represent a skateboarding tip
data class SkateboardingTip(
    val title: String,
    val description: String,
    val imageUrl: Int // Resource ID for the image
)

// Sample list of skateboarding tips
val skateboardingTips = listOf(
    //1
    SkateboardingTip(
        "Mastering the Ollie",
        "The ollie is the fundamental trick in skateboarding. " +
                "Learn how to pop your board and slide your front foot to level out in mid-air.",
        R.drawable.ollie
    ),
    //2
    SkateboardingTip(
        "Spot Finder",
        "Discover skate spots in your area and around the world, including skate parks, street spots, DIY spots, and hidden gems. ",
        R.drawable.skatepark
    ),
    //3
    SkateboardingTip(
        "Choosing the Right Skate Shoes",
        "Skate shoes play a crucial role in your performance and safety. " +
                "Look for durable materials, good grip, and ankle support.",
        R.drawable.shoes
    ),
    //4
    SkateboardingTip(
        "Skateboard Setup Guides",
        "Setting up your skateboard correctly is essential for optimal performance and safety. " +
                "Make sure to choose the right components, including durable materials for your deck. ",
        R.drawable.sitdown
    ),
    //5
    SkateboardingTip(
        "Skateboarding Culture & History",
        "Dive into the rich culture and history of skateboarding with articles, interviews, documentaries, and archival footage celebrating iconic skaters, legendary tricks, and influential skate brands. ",
        R.drawable.riding
    ),
    //6
    SkateboardingTip(
        "Safety & Injury Prevention",
        "Access resources and tips for skateboarding safety, injury prevention, warm-up exercises, and first aid techniques. " +
                "Learn how to skate responsibly and minimize the risk of accidents.",
        R.drawable.gear
    ),
    //7
    SkateboardingTip(
        "Skateboarding Dictionary",
        "Brush up on skateboarding terminology with a comprehensive dictionary of tricks, slang, and jargon used in the skateboarding community.  ",
        R.drawable.chitchat
    ),
    //8
    SkateboardingTip(
        "Basic Skateboarding Stance",
        "Mastering your skateboarding stance is the first step in learning to skate. " +
                "Whether you're regular or goofy, find your most comfortable position on the board.",
        R.drawable.standhold
    ),
    //9
    SkateboardingTip(
        "Dropping In",
        "Dropping in is a fundamental skill for riding ramps and bowls. " +
                "Learn the proper technique for dropping in safely and confidently.",
        R.drawable.dropin
    ),
    //10
    SkateboardingTip(
        "Flip Tricks",
        "Flip tricks are advanced maneuvers that involve flipping and spinning the board. " +
                "Start with basic flip tricks like kickflips and heelflips before progressing to harder tricks.",
        R.drawable.kickflip
    ),
    // Add more skateboarding tips as needed
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _10days_Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black // Set background color to black for a sleek look
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
                            text = "10 Days of Skateboarding Tips",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White // Set text color to white for contrast
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Whether you're a seasoned skater or just getting started, this app is designed to inspire & educate skateboarders worldwide.",
                            fontSize = 15.sp,
                            color = Color.Gray, // Set text color to gray for subtlety
                            textAlign = TextAlign.Center
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
    Image(
        painter = painterResource(id = R.drawable.groupskaterkids), // Add your header image resource
        contentDescription = "Header Image",
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}


// Composable function to display a single skateboarding tip card
@Composable
fun SkateboardingTipCard(skateboardingTip: SkateboardingTip) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.DarkGray, // Change the background color here
        shape = RoundedCornerShape(16.dp) // Increase corner radius for a sleek look
    ) {
        Card(
            modifier = Modifier.padding(8.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally // Center align content
            ) {
                Text(
                    text = skateboardingTip.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black, // Use black color for title text
                    modifier = Modifier.padding(bottom = 8.dp) // Add bottom padding to title
                )
                Text(
                    text = skateboardingTip.description,
                    fontSize = 16.sp,
                    color = Color.DarkGray, // Use dark gray color for description text
                    modifier = Modifier.padding(bottom = 16.dp) // Add bottom padding to description
                )
                Image(
                    painter = painterResource(id = skateboardingTip.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp), // Adjust image height for a sleeker appearance
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

// Composable function to display a list of skateboarding tips
@Composable
fun SkateboardingTipsList(skateboardingTips: List<SkateboardingTip>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(skateboardingTips) { tip ->
            SkateboardingTipCard(skateboardingTip = tip)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    _10days_Theme {
        SkateboardingTipsList(skateboardingTips)
    }
}
