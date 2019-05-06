package teamproject.model

object Level {

  def apply(number: Int): Level = {
    new Level {
      gridHeight = 24
      gridWidth = 24
      startingLocation = new GridLocation(1, 1)
      base = new GridLocation(22, 22)

      wallLocations = List(
        new GridLocation(0,0),
        new GridLocation(0,1),
        new GridLocation(0,2),
        new GridLocation(0,3),
        new GridLocation(0,4),
        new GridLocation(0,5),
        new GridLocation(0,6),
        new GridLocation(0,7),
        new GridLocation(0,8),
        new GridLocation(0,9),
        new GridLocation(0,10),
        new GridLocation(0,11),
        new GridLocation(0,12),
        new GridLocation(0,13),
        new GridLocation(0,14),
        new GridLocation(0,15),
        new GridLocation(0,16),
        new GridLocation(0,17),
        new GridLocation(0,18),
        new GridLocation(0,19),
        new GridLocation(0,20),
        new GridLocation(0,21),
        new GridLocation(0,22),
        new GridLocation(0,23),

        new GridLocation(1,0),
        new GridLocation(2,0),
        new GridLocation(3,0),
        new GridLocation(4,0),
        new GridLocation(5,0),
        new GridLocation(6,0),
        new GridLocation(7,0),
        new GridLocation(8,0),
        new GridLocation(9,0),
        new GridLocation(10,0),
        new GridLocation(11,0),
        new GridLocation(12,0),
        new GridLocation(13,0),
        new GridLocation(14,0),
        new GridLocation(15,0),
        new GridLocation(16,0),
        new GridLocation(17,0),
        new GridLocation(18,0),
        new GridLocation(19,0),
        new GridLocation(20,0),
        new GridLocation(21,0),
        new GridLocation(22,0),

        new GridLocation(23,0),
        new GridLocation(23,1),
        new GridLocation(23,2),
        new GridLocation(23,3),
        new GridLocation(23,4),
        new GridLocation(23,5),
        new GridLocation(23,6),
        new GridLocation(23,7),
        new GridLocation(23,8),
        new GridLocation(23,9),
        new GridLocation(23,10),
        new GridLocation(23,11),
        new GridLocation(23,12),
        new GridLocation(23,13),
        new GridLocation(23,14),
        new GridLocation(23,15),
        new GridLocation(23,16),
        new GridLocation(23,17),
        new GridLocation(23,18),
        new GridLocation(23,19),
        new GridLocation(23,20),
        new GridLocation(23,21),
        new GridLocation(23,22),
        new GridLocation(23,23),

        new GridLocation(0,23),
        new GridLocation(1,23),
        new GridLocation(2,23),
        new GridLocation(3,23),
        new GridLocation(4,23),
        new GridLocation(5,23),
        new GridLocation(6,23),
        new GridLocation(7,23),
        new GridLocation(8,23),
        new GridLocation(9,23),
        new GridLocation(10,23),
        new GridLocation(11,23),
        new GridLocation(12,23),
        new GridLocation(13,23),
        new GridLocation(14,23),
        new GridLocation(15,23),
        new GridLocation(16,23),
        new GridLocation(17,23),
        new GridLocation(18,23),
        new GridLocation(19,23),
        new GridLocation(20,23),
        new GridLocation(21,23),
        new GridLocation(22,23),

        new GridLocation(3,3),
   //     new GridLocation(2,4),
        new GridLocation(3,5),
        new GridLocation(3,6),
        new GridLocation(3,7),
        new GridLocation(3,8),
        new GridLocation(3,9),
        new GridLocation(3,10),
        new GridLocation(3,11),
        new GridLocation(3,12),
        new GridLocation(3,13),
        new GridLocation(3,14),
        new GridLocation(3,15),
        new GridLocation(3,16),

        new GridLocation(4,17),
        new GridLocation(5,18),
        new GridLocation(6,19),
        new GridLocation(7,20),

        new GridLocation(4,3),
        new GridLocation(5,4),
        new GridLocation(6,5),
        new GridLocation(7,6),
        new GridLocation(8,7),
        new GridLocation(9,8),
        new GridLocation(9,9),
        new GridLocation(9,10),
        new GridLocation(9,11),
        new GridLocation(9,12),
        new GridLocation(9,13),
        new GridLocation(9,14),
        new GridLocation(9,15),
        new GridLocation(9,16),

        new GridLocation(10,17),
        new GridLocation(11,18),
        new GridLocation(12,19),
        new GridLocation(13,20),



        new GridLocation(9,3),
        new GridLocation(10,4),
        new GridLocation(11,5),
        new GridLocation(12,6),
        new GridLocation(13,7),
        new GridLocation(14,8),
        new GridLocation(15,9),
        new GridLocation(15,10),
        new GridLocation(15,11),
        new GridLocation(15,12),
        new GridLocation(15,13),
        new GridLocation(15,14),
        new GridLocation(15,15),
        new GridLocation(15,16),

        new GridLocation(16,17),
        new GridLocation(17,18),
        new GridLocation(18,19),
        new GridLocation(19,20),



        //        new GridLocation(10,3),
        new GridLocation(11,3),
        new GridLocation(12,3),
        new GridLocation(13,3),
        new GridLocation(14,3),
        new GridLocation(15,3),
        new GridLocation(16,3),
        new GridLocation(17,3),
        new GridLocation(18,3),
//        new GridLocation(19,3),
        new GridLocation(20,3),

        new GridLocation(20,4),
        new GridLocation(20,5),
        new GridLocation(20,6),
        new GridLocation(20,7),
        new GridLocation(20,8),
        new GridLocation(20,9),
        new GridLocation(20,10),
        new GridLocation(20,11),
        new GridLocation(20,12),
        new GridLocation(20,13),
        new GridLocation(20,14),
        new GridLocation(20,15),
        new GridLocation(20,16),












        //new GridLocation(),


      )
    }
    /*new Level {
      gridWidth = 19
      gridHeight = 19

      startingLocation = new GridLocation(0, 18)
      base = new GridLocation(18, 0)

      wallLocations = List(
        new GridLocation(2, 5),
        new GridLocation(2, 6),
        new GridLocation(2, 7),
        new GridLocation(2, 8),
        new GridLocation(2, 9),
        new GridLocation(2, 10),
        //          new GridLocation(2,11),
        new GridLocation(2, 12),
        new GridLocation(2, 13),

        new GridLocation(5, 2),
        new GridLocation(6, 2),
        new GridLocation(7, 2),
        new GridLocation(8, 2),
        new GridLocation(9, 2),
        new GridLocation(10, 2),
        new GridLocation(11, 2),
        new GridLocation(12, 2),
        new GridLocation(13, 2),
        new GridLocation(16, 2),

        new GridLocation(5, 16),
        new GridLocation(6, 16),
        //          new GridLocation(7,16),
        new GridLocation(8, 16),
        new GridLocation(9, 16),
        new GridLocation(10, 16),
        new GridLocation(11, 16),
        new GridLocation(12, 16),
        new GridLocation(13, 16),


        new GridLocation(16, 5),
        new GridLocation(16, 6),
        new GridLocation(16, 7),
        new GridLocation(16, 8),
        new GridLocation(16, 9),
        new GridLocation(16, 10),
        new GridLocation(16, 11),
        new GridLocation(16, 12),
        new GridLocation(16, 13),


        new GridLocation(3, 5),
        new GridLocation(3, 13),

        new GridLocation(4, 6),
        new GridLocation(4, 12),

        new GridLocation(5, 3),
        new GridLocation(5, 7),
        new GridLocation(5, 11),
        new GridLocation(5, 15),

        new GridLocation(6, 4),
        new GridLocation(6, 8),
        new GridLocation(6, 14),

        new GridLocation(7, 5),
        new GridLocation(7, 9),
        new GridLocation(7, 13),

        new GridLocation(8, 6),

        new GridLocation(9, 7),
        new GridLocation(9, 11),

        new GridLocation(10, 6),
        new GridLocation(10, 12),

        new GridLocation(11, 9),
        new GridLocation(11, 13),

        new GridLocation(12, 4),
        new GridLocation(12, 8),
        new GridLocation(12, 10),
        new GridLocation(12, 14),

        new GridLocation(13, 3),
        new GridLocation(13, 11),
        new GridLocation(13, 15),

        new GridLocation(14, 6),
        new GridLocation(14, 12),

        new GridLocation(15, 5),
        new GridLocation(15, 13)
        )
    }*/
  }




}

class Level {
  var wallLocations:List[GridLocation] = List()

  var gridWidth: Int = 25
  var gridHeight: Int = 9

  var startingLocation = new GridLocation(0, 3)
  var base = new GridLocation(24, 3)
}
