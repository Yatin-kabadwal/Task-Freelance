# Coupon Links App
A simple Android application built using Kotlin and XML in Android Studio. The app allows users to browse, shuffle, and open coupon links for different brands.

##📌 Features
✅ View Brand Links – Displays a list of brands with their respective coupon links.
✅ Shuffle Feature – Randomly rearranges the list when the "Shuffle" button is clicked.
✅ Open Coupon Details – Clicking a brand opens a new screen with more details.
✅ Long Press to Copy Link (Optional) – Users can long-press a link to copy it to the clipboard.


## 🛠 Technologies Used
Kotlin – For Android development
XML – For UI design
RecyclerView – To display coupon links
Intents – For navigation between activities

## 🚀 How It Works
1️⃣ Viewing Coupon Links
The app displays a list of brands with their respective coupon links.
The data is shown using a RecyclerView inside LinksFragment.kt.
2️⃣ Shuffle Functionality
Clicking the Shuffle button randomly rearranges the list.
Implemented using the shuffle() function in Kotlin.
3️⃣ Opening Coupon Details
Clicking on a brand opens CouponActivity.kt, showing more details.
The data is passed using Intent extras.
