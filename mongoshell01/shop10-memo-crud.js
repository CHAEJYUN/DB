use shop10

db.memo.find({}) //전체검색

db.memo.count({}) //document 개수

db.memo.insertOne({
    "name" : "apple",
    "age" : 100
})

db.memo.find({"name" : "apple"}) //조건검색

db.memo.find({"age" : 100})

db.createCollection("member") //collection 생성

db.member.stats()

db.member.insertOne({
    "name" : "hong",
    "age" : 100
})

db.member.find({})

db.member.drop() //member collection 삭제

show databases //저어어언체

db.createCollection("bbs")

db.bbs.insertOne({"title" : "win"})

db.bbs.find({})

db.dropDatabase() //shop10 db 삭제

show databases