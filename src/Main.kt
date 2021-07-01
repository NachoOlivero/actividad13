import java.util.*


fun main(args: Array<String>) {
    println("\nFlujo maximo: ${EdmonsKarp().edmonsKarp()}")
}

class EdmonsKarp {

    private var cantNodos = 0
    private var cantArcos = 0
    private var s = 0
    private var t = 0
    private lateinit var arcos: Array<IntArray>
    private lateinit var flujo: Array<IntArray>

    private var cf = 0
    private lateinit var padre: IntArray

    fun edmonsKarp(): Int {
        val sc = Scanner(System.`in`)

        cantNodos = sc.nextInt()
        cantArcos = sc.nextInt()

        arcos = Array(cantNodos) { IntArray(cantNodos) }
        flujo = Array(cantNodos) { IntArray(cantNodos) }

        s = sc.nextInt()-1
        t = sc.nextInt()-1

        for(i in 0 until cantArcos) {
            val u = sc.nextInt()
            val v = sc.nextInt()
            val cap = sc.nextInt()
            arcos[u-1][v-1] = cap
        }

        while (true) {
            if(!bfs())
                break
            var nodo = t
            var nodoPadre: Int

            while (nodo != s) {
                nodoPadre = padre[nodo]
                flujo[nodo][nodoPadre] -= cf
                flujo[nodoPadre][nodo] += cf
                nodo = nodoPadre
            }
        }

        var maxFlujo = 0
        for (i in 0 until cantNodos)
            maxFlujo += flujo[s][i]

        return maxFlujo
    }

    private fun bfs(): Boolean {
        cf = Int.MAX_VALUE
        padre = IntArray(cantNodos)

        var visitado = BooleanArray(cantNodos)
        var cola: Queue<Int> = ArrayDeque()
        visitado[s] = true

        cola.add(s)
        while(!cola.isEmpty()) {
            var arco = cola.remove()
            for(i in 0 until cantNodos)
                if(!visitado[i] && arcos[arco][i] > flujo[arco][i]) {
                    visitado[i] = true
                    padre[i] = arco
                    cf = cf.coerceAtMost(arcos[arco][i] - flujo[arco][i])

                    if (i != t) {
                        cola.add(i)
                    }
                    else return true
                }
        }
        return false
    }
}
