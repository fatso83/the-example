package fakes

import notifications.UserNotificationClient

class UserNotificationClientFake : UserNotificationClient {
    private val notifications = mutableMapOf<String, MutableList<String>>()

    /**
     * Only in the Fake
     */
    fun getNotificationForUser(name: String): List<String> {
        return notifications.getOrDefault(name, emptyList())
    }

    override fun notifyUser(name: String, message: String) {
        notifications.getOrPut(name, ::mutableListOf).add(message)
    }

}
