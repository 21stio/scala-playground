trait TModel {
  def getName: String
}

trait TRepository {
  def getModels: List[TModel]
}

class PetModel(name: String) extends TModel {
  override def getName: String = name
}

class PetRepository(pets: List[TModel]) extends TRepository {
  override def getModels: List[TModel] = pets

  def printNames() =
    for (model <- getModels) print(model.getName)
}

object HelloWorld extends App {
  val pets: List[TModel] = List(
    new PetModel("Peter"),
    new PetModel("Hans"),
    new PetModel("Wurst")
  )

  val repository: PetRepository = new PetRepository(pets)

  repository.printNames()
}