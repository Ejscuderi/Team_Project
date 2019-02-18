import bottle

@bottle.route('/')
def index():
    return bottle.static_file("htmlFinal.html", root="")


@bottle.route('/pieFinal.js')
def pie():
    return bottle.static_file("pieFinal.js", root="")


@bottle.route('/incidentsFinal')
def ticketFromCode():
    a = "https://data.buffalony.gov/resource/d6g9-xbgu.json"
    return incidentsFinal.get_incident_data(a)


@bottle.route('/mapFinal.js')
def map():
    return bottle.static_file("mapFinal.js", root="")


@bottle.route('/buffalo')
def fromCode():
    b = "https://data.buffalony.gov/resource/y4af-i7y2.json"
    return incidentsFinal.get_buff_data(b)


bottle.run(host="0.0.0.0", port=8080, debug=True)
