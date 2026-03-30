# Spark Chat – Android Application

## Overview

**Spark Chat** is an Android-based mobile application designed to support and enhance users’ social connectivity through context-aware interaction prompts. By generating tailored “social sparks” based on the time of day, the application encourages consistent and meaningful communication with friends, family, and colleagues.

The solution is particularly suited for individuals with demanding schedules who may struggle to maintain regular social engagement.

---

## Objectives

The primary objectives of the Spark Chat application are:

- To provide intelligent, time-based social interaction suggestions  
- To design and implement a clean, user-friendly chat-style interface using **Kotlin** and **Android Studio**  
- To incorporate version control using **GitHub**, alongside **GitHub Actions** for automated builds, testing, and continuous integration  

---

## Features

- Time-sensitive social interaction recommendations  
- Lightweight and responsive user interface  
- Predefined “social spark” messaging system  
- Scalable architecture for future feature enhancements  

---

## Social Spark Suggestion Logic

The application delivers predefined suggestions aligned with specific periods of the day to promote consistent engagement.

### Time-Based Interaction Prompts

| Time of Day | Suggested Interaction |
|-------------|----------------------|
| Morning | Send a “Good morning” message to a family member |
| Mid-morning | Express appreciation by sending a quick “Thank you” to a colleague |
| Afternoon | Share a humorous meme or interesting content with a friend |
| Snack Time | Send a brief “Thinking of you” message |
| Dinner | Make a short call to a friend or relative for a quick catch-up |
| Night | Leave a thoughtful comment on a friend’s social media post |

---

## Technical Implementation

The core functionality of the application is implemented using conditional logic in Kotlin to map user input (time of day) to predefined responses.

### Example Code Snippet

```kotlin
val response = when (time) {
    "morning" -> "Send a Good morning message to a family member"
    "mid-morning" -> "Send a quick Thank You message to a colleague"
    "afternoon" -> "Share a funny meme with a friend"
    "snack time" -> "Send a 'thinking of you' message"
    "dinner" -> "Call a friend for a quick catch-up"
    "night" -> "Leave a thoughtful comment on a post"
    else -> "Invalid input. Please enter a valid time (Morning, Afternoon, Dinner, Night)."
}