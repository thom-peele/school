def getBlock(x, y, latitude, longitude):
    # plot.savefig('hanning{0}.pdf'.format(num))
    return """
        <dict>
            <key>discovered</key>
		    <false/>            
		    <key>x</key>
            <integer>{0}</integer>
            <key>y</key>
            <integer>{1}</integer>
            <key>tile</key>
            <array>
                <dict>
                    <key>latitude</key>
                    <real>{2}</real>
                    <key>longitude</key>
                    <real>{3}</real>
                </dict>
                <dict>
                    <key>latitude</key>
                    <real>{4}</real>
                    <key>longitude</key>
                    <real>{5}</real>
                </dict>
                <dict>
                    <key>latitude</key>
                    <real>{6}</real>
                    <key>longitude</key>
                    <real>{7}</real>
                </dict>
                <dict>
                    <key>latitude</key>
                    <real>{8}</real>
                    <key>longitude</key>
                    <real>{9}</real>
                </dict>
            </array>
        </dict>""".format(x, y, latitude, longitude, latitude + 0.188981, longitude, latitude + 0.188981,
                          longitude + 0.319173, latitude, longitude + 0.319173)

latitude = 50.738892
for i in range(15):
    longitude = 3.337965
    for j in range(12):
        print getBlock(0, 0, latitude, longitude)
        longitude += 0.319173
    latitude += 0.188981
