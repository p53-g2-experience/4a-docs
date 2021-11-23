from rest_framework import status, views
from rest_framework.response import Response
from dictionaryApp.models.word import Word
from dictionaryApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated

from dictionaryApp.serializers import WordSerializer

class WordDeleteView(views.APIView):

    def delete(self, request, *args, **kwargs):
        try:
            if  Functions_Global.is_Authenticated(request):
                word = Word.objects.filter(id = kwargs['pk']).first()
                wordSerializer = WordSerializer(word)
                word.delete()
                return Response(status=status.HTTP_204_NO_CONTENT)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)