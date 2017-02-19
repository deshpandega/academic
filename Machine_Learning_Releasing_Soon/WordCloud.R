Needed <- c("tm", "SnowballCC", "RColorBrewer", "ggplot2", "wordcloud", "biclust", "cluster", "igraph", "fpc")

install.packages(Needed, dependencies=TRUE)

install.packages("Rcampdf", repos = "http://datacube.wu.ac.at/", type = "source")

cname <- file.path("C:", "texts")

cname

dir(cname)

library(tm)
library(wordcloud)

docs <- Corpus(DirSource(cname))

summary(docs)

inspect(docs[1])
inspect(docs[2])

docs <- tm_map(docs, stripWhitespace)

docs <- tm_map(docs, tolower)

docs <- tm_map(docs, removeWords, stopwords("english"))

docs <- tm_map(docs, removePunctuation)

docs <- tm_map(docs, stemDocument)

docs <- tm_map(docs, PlainTextDocument)

docs <- tm_map(docs, content_transformer(tolower))

docs <- tm_map(docs, removeNumbers)


wordcloud(docs, max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE)
wordcloud(docs[1], max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE)
wordcloud(docs[2], max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE)

wordcloud(docs, max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE, colors=brewer.pal(12, "Set3"))
wordcloud(docs[1], max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE, colors=brewer.pal(8, "Set2"))
wordcloud(docs[2], max.words=250, random.order=FALSE, rot.per=0.35, use.r.layout=FALSE, colors=brewer.pal(9, "Set1"))