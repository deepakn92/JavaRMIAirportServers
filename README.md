# JavaRMIAirportServers
Java RMI uses Google Protocol Buffers and Client-Server programming
The client looks up the two RMI services: the first for looking up places and the second for finding nearby airports. It then contacts the first service to look up the place (city, state) to find its latitude and longitude and then contacts the second service to get a list of nearest airports. In summary:

look up the places server
look up the airports server
{place name, state, latitude, longitude} = find_place(city, state)
print full place name, state, latitude, longitude
list of five nearest: {airport code, state, distance} = find_airports(latitude, longitude)
print each airport code, airport name, distance
