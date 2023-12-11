package com.cesarwillymc.kmplogin.presentation.utils.lottie


//import kotlinx.coroutines.Job
//import org.jetbrains.skia.Data
//import org.jetbrains.skia.Rect
//import org.jetbrains.skia.skottie.Animation
//import org.jetbrains.skia.sksg.InvalidationController

/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
//@Composable
//fun LottieAnimation() {
//    val animation = Animation.makeFromString(lottieData)
//    InfiniteAnimation(animation, Modifier.fillMaxSize())
//}
//
//@Composable
//fun InfiniteAnimation(animation: Animation, modifier: Modifier) {
//    val infiniteTransition = rememberInfiniteTransition()
//    val time by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = animation.duration,
//        animationSpec = infiniteRepeatable(
//            animation = tween((animation.duration * 1000).roundToInt(), easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        )
//    )
//    val invalidationController = remember { InvalidationController() }
//    animation.seekFrameTime(time, invalidationController)
//    Canvas(modifier) {
//        drawIntoCanvas {
//            animation.render(
//                canvas = it.nativeCanvas,
//                dst = { Rect.makeWH(size.width, size.height) }
//            )
//        }
//    }
//}
//@Composable
//fun LottieAnimation(
//    modifier: Modifier,
//    animationRoute: String,
//    restart: Boolean,
//    loading: @Composable () -> Unit = {},
//) {
//    var animation by remember { mutableStateOf<Animation?>(null) }
//
//    LaunchedEffect(Unit) {
//        animation = Animation.makeFromData(Data.makeFromBytes(animationRoute.readByteArray()))
//    }
//
//    when (val value = animation) {
//        null -> loading()
//        else -> SkiaAnimation(
//            modifier = modifier,
//            animation = value,
//            restart = restart
//        )
//    }
//}
//
//@Composable
//private fun SkiaAnimation(
//    modifier: Modifier,
//    animation: Animation,
//    restart: Boolean,
//) {
//    var elapsedSeconds: Float by remember { mutableStateOf(DefaultElapsedSeconds) }
//    var lastTimeInMillis: Long by remember { mutableStateOf(DefaultLastTimeInMillis) }
//    val invalidationController = remember { InvalidationController() }
//
//
//    Surface(
//        modifier = modifier
//            .drawAnimationOnCanvas(
//                animation = animation,
//                time = elapsedSeconds,
//                invalidationController = invalidationController
//            )
//    ) {}
//
//
//    LaunchedEffect(Unit) {
//        while (this.coroutineContext[Job]?.isActive == true) {
//            withFrameMillis { absoluteMillis ->
//                if (lastTimeInMillis > DefaultLastTimeInMillis) {
//                    val deltaMillis =
//                        (absoluteMillis - lastTimeInMillis)
//                    elapsedSeconds += deltaMillis / MillisecondsInOneSecond
//                }
//                lastTimeInMillis = absoluteMillis
//            }
//
//            if (elapsedSeconds >= animation.duration) {
//                elapsedSeconds %= animation.duration
//            }
//        }
//    }
//}
//
//private fun Modifier.drawAnimationOnCanvas(
//    animation: Animation,
//    time: Float,
//    invalidationController: InvalidationController
//): Modifier = this then drawWithContent {
//    drawIntoCanvas { canvas ->
//        animation.seekFrameTime(time, invalidationController)
//        animation.render(
//            canvas = canvas.nativeCanvas,
//            dst = Rect.makeWH(size.width, size.height),
//        )
//    }
//}
//
//private const val MillisecondsInOneSecond = 1000F
//private const val DefaultElapsedSeconds = 0f
//private const val DefaultLastTimeInMillis = 0L

