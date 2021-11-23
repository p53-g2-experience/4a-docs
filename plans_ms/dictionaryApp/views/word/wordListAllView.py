from rest_framework import status, views
from rest_framework.response import Response
from dictionaryApp.models.word import Word

from dictionaryApp.serializers import WordSerializer

class WordListAllView(views.APIView):


    def get(self, request, *args, **kwargs):
     
        try:
            words = Word.objects.all()
            wordSerializer = WordSerializer(words, many= True)
            return Response(wordSerializer.data, status = status.HTTP_200_OK)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)