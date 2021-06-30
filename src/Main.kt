class EdmonsKarp {

    private var cantNodos = 0
    private var cantArcos = 0
    private var s = 0
    private var t = 0
    private lateinit var arcos: Array<IntArray>
    private lateinit var flujo: Array<IntArray>

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
            val cf = bfs()
            if(false/*alguna condicion*/)
                break
            for(i in 1..5) {
                flujo[i][i] += cf
                flujo[i][i] -= cf
            }
        }

        var maxFlujo = 0
        for(i in 0 until cantNodos-1)
            maxFlujo+=flujo[s][i]

        return maxFlujo
    }

    private fun bfs():Int {
        return 0
    }
}
