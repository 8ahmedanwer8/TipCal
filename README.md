# TipCalAndroidApp
Simple Android app for calculating restaurant tip and deployed to the play store.
Check it out on the playstore https://play.google.com/store/apps/details?id=com.confuseddevs.tipcal 

This is the first app I published to the playstore and learned to build using Android. It is a single screen app with dynamic text, animations, Android UI elements (seekbar, constraint layout) , color interpolation, smooth UX and splashscreens which I designed on Photoshop. A lot of dimensions can be added to this app such as integrating Room or a service like Firebase to allow users to store foods eaten and share restaurants visited with other users (actually, that sounds like a good app idea!?).

The app was a good starter for me on fullstack development for mobile applications and the biggest challenge was making the splashscreen responsive. It seems like if you have a PNG or JPG file, the app will not resize based on the viewport. So, that led me to create several different copies of the splashscreen with different resolutions and launch the approporiate one by reading the size of the viewport. 
