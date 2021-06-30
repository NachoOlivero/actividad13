class EdmonsKarp {

    private var cantNodos = 0
    private var cantArcos = 0
    private var s = 0
    private var t = 0
    private lateinit var arcos: Array<IntArray>
    private lateinit var flujo: Array<IntArray>

    private var cf = 0
    private lateinit var padre: IntArray

    fun main(args: Array<String>) {
        println(edmonsKarp())
    }

    fun edmonsKarp(): Int {
        // leo los valores n y m
        // leo s y t
        // leo los arcos
        arcos = Array(cantNodos) { IntArray(cantNodos) }
        flujo = Array(cantNodos) { IntArray(cantNodos) }

        while (true) {
            bfs()
            if(cf == 0)
                break
            var nodo = t
            var nodoPadre: Int
            while(nodo != s) {
                nodoPadre = padre[nodo]
                flujo[nodo][nodoPadre] += cf
                flujo[nodoPadre][nodo] -= cf
                nodo = nodoPadre
            }
        }

        var maxFlujo = 0
        for(i in 0 until cantNodos-1)
            maxFlujo+=flujo[s][i]

        return maxFlujo
    }

    private fun bfs() {
        cf = 0
        padre = IntArray(cantNodos)
        // queda hacer o ver si esta hecho
}
