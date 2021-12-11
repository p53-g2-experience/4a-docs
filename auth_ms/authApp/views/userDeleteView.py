from rest_framework import status, views
from rest_framework.response import Response
from authApp.models.user import User
from authApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated

from authApp.serializers.userSerializer import UserSerializer

class UserDeleteView(views.APIView):

    def delete(self, request, *args, **kwargs):
        try:
            if  Functions_Global.is_Authenticated(request):
                user = User.objects.filter(id = kwargs['pk']).first()
                user.delete()
                return Response(status=status.HTTP_204_NO_CONTENT)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)