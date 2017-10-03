object Rules {
  val utf8 = mapOf( 
    '↑' to '→',
    '↓' to '←',
    '←' to '↑',
    '→' to '↓',
    'ー' to '｜',
    '─' to '｜',
    '−' to '｜',
    '－' to '｜',
    '—' to '︱',
    '〜' to '∫',
    '～' to '∫',
    '／' to '＼',
    '…' to '︙',
    '‥' to '︰',
    '：' to '︓',
    ':' to '︓',
    '；' to '︔',
    ';' to '︔',
    '＝' to '॥',
    '=' to '॥',
    '（' to '︵',
    '(' to '︵',
    '）' to '︶',
    ')' to '︶',
    '［' to '﹇',
    '[' to '﹇',
    '］' to '﹈',
    ']' to '﹈',
    '｛' to '︷',
    '{' to '︷',
    '＜' to '︿',
    '<' to '︿',
    '＞' to '﹀',
    '>' to '﹀',
    '｝' to '︸',
    '}' to '︸',
    '「' to '﹁',
    '」' to '﹂',
    '『' to '﹃',
    '』' to '﹄',
    '【' to '︻',
    '】' to '︼',
    '〖' to '︗',
    '〗' to '︘',
    '｢' to '﹁',
    '｣' to '﹂',
    ',' to '、')
}


fun main( args : Array<String> ) {
  val buff = mutableListOf<String>()
  scan@while(true) {
    val line = readLine()
    if( line == null ) break@scan
    buff.add( line!!.replace("\n", "") )
  }
  
  val chars = buff.map { it.toList().map {
      when {
        Rules.utf8.get(it) != null -> Rules.utf8[it]!!
        it == null -> '　'
        else -> it
      }
    }.toMutableList() }
  val max_size = chars.map { it.size }.max()!!
  chars.map {
    while( it.size <= max_size ){
      it.add('　')
    }
  }
  val width_size = chars.size
  val height_size = chars.map { it.size }.max()!!
  val trans = (1..height_size).map { mutableListOf<Char>() }.toList()

  chars.mapIndexed { y,lines ->
    val targetY = width_size - y - 1
    lines.mapIndexed { i,ch ->
      trans[i].add(0, ch )
    }
  }
  trans
    .map { it.map { it.toString() }.joinToString(" ") }
    .map{ println( it ) }
}
