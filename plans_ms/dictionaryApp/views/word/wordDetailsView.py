from rest_framework import status, views
from rest_framework.response import Response
from dictionaryApp.models.word import Word
from dictionaryApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated
from dictionaryApp.serializers import WordSerializer
from rest_framework import generics

class UserDetailView(generics.RetrieveAPIView):
    queryset = Word.objects.all()
    serializer_class = WordSerializer


#class WordDetailsView(views.APIView):
#
#    def get(self, request, *args, **kwargs):
#        try:
#            word = Word.objects.filter(id = kwargs['pk']).first()
#            wordSerializer = WordSerializer(word)
#            return Response(wordSerializer.data, status = status.HTTP_200_OK)
#        except Exception as ex:
#            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)
# 