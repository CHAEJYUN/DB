use shop5

db.getCollection("memo").find({})

db.memo.find({}) //ctrl + enter

db.createUser({
  user : "winner",
  pwd : "1234",
  roles : ["readWrite", "dbAdmin"]
})
